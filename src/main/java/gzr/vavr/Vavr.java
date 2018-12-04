package gzr.vavr;

import io.vavr.Tuple2;

/**
 * @author gaozengrong
 * @date 2018/08/15
 */
public class Vavr {
    public static void main(String[] args) {
        Tuple2<Integer, String> pair = new Tuple2<>(4, "Four");
        System.out.println(pair);
        pair = pair.update1(1);
        System.out.println(pair);
        pair = pair.update2("One");
        System.out.println(pair);
    }
}
