package gzr.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream常用方法
 *
 * @author zengrong.gzr
 * @date 2017/08/11
 */
public class StreamHelper {
    public static void main(String[] args) {
        boolean noneMatch = Stream.of(1, 2, 3, 4, 5)
            .noneMatch(integer -> integer > 10);
        System.out.println("noneMatch:" + noneMatch); // 打印结果 noneMatch:true

        boolean noneMatch_ = Stream.of(1, 2, 3, 4, 5)
            .noneMatch(integer -> integer < 3);
        System.out.println("noneMatch_:" + noneMatch_); // 打印结果 noneMatch_:false

        //比较两个list是否元素全部相等
        List<String> list1 = Stream.of("1", "2", "3", "4", "5").collect(Collectors.toList());
        List<String> list2 = Stream.of("5", "4", "3", "2", "1").collect(Collectors.toList());
        boolean compareResult = list1.stream().allMatch(list2::contains);
        System.out.println("compareResult:" + compareResult); // 打印结果 compareResult:true
    }
}
