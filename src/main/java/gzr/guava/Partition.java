package gzr.guava;

import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

/**
 * 分组
 *
 * @author zengrong.gzr
 * @date 2017/07/04
 */
public class Partition {
    public static void main(String[] args) throws InterruptedException {
        List<Long> list = Lists.newArrayList();
        for (int i = 0; i < 101; i++) {
            list.add((long)i);
        }
        //分组 每组10个
        List<List<Long>> partitions = Lists.partition(list, 10);
        System.out.println("partitions size is " + partitions.size());

        ExecutorService executor = Executors.newFixedThreadPool(partitions.size());
        CompletionService<Long> cs = new ExecutorCompletionService<>(executor);

        System.out.println("print all data concurrently");
        partitions.forEach(partition -> {
            cs.submit(() -> {
                partition.forEach(System.out::println);
                return partition.get(0);
            });
        });

        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("print concurrent result");
        partitions.forEach(partition -> {
            try {
                System.out.println(cs.take().get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
