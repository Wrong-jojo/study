package gzr.guava;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 分组
 *
 * @author zengrong.gzr
 * @date 2017/07/04
 */
public class Partition {
    public static void main(String[] args) {
        List<Long> list = Lists.newArrayList();
        for (int i = 0; i < 101; i++) {
            list.add((long)i);
        }
        //分组 每组10个
        List<List<Long>> partitions = Lists.partition(list, 10);
        System.out.println("partitions size is " + partitions.size());
        for (List<Long> partition : partitions) {
            System.out.println(partition.get(0));
        }
    }
}
