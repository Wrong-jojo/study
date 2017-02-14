package gzr.annotation;

import java.io.IOException;

/**
 * Created by gaozengrong on 17/1/5.
 */
@TestAnnotation(count = 22)
public class TestMain {
    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException, IOException {
        TestAnnotation annotation = TestMain.class.getAnnotation(TestAnnotation.class);
        //System.in.read()返回的是输入数值的 ASKII 码（一个 int 整数）
        System.out.println(annotation.count());
        int a = System.in.read();
        System.out.println(a);
    }
}
