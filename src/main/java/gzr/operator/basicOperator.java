package gzr.operator;

/**
 * 基本运算符
 * Created by gaozengrong on 16/12/28.
 */
public class basicOperator {
    public static void main(String[] args) {
        //测试位移运算符
        System.out.println(Long.toBinaryString(1<<1));
        //测试取反运算符
        System.out.println(Long.toBinaryString(~(1<<1)));
    }
}
