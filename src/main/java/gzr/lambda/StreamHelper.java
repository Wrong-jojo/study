package gzr.lambda;

import java.util.stream.Stream;

/**
 * 常用方法
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
    }
}
