package gzr.thread;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

/**
 * @author zengrong.gzr
 * @date 2017/07/04
 */
public class Completion {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int threadNum = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        CompletionService<Long> cs = new ExecutorCompletionService<>(executor);

        for (int i = 0; i < threadNum; i++) {
            int finalI = i;
            cs.submit(() -> {
                TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 1000 % 10));
                return (long)finalI;
            });
        }

        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("print concurrent result");
        for (int i = 0; i < threadNum; i++) {
            //如果阻塞队列中有已完成的任务, take方法就返回任务的结果, 否则阻塞等待任务完成
            System.out.println(cs.take().get());
        }

    }
}
