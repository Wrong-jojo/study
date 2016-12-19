package gzr.generics;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 泛型擦除
 * Created by gaozengrong on 16/12/19.
 */
public class TypeErasure {
    public static void main(String[] args) {
        typeErasure();
        testErasure();
    }

    private static void typeErasure(){
        List<Long> longList = Lists.newArrayList();
        List<String> stringList = Lists.newArrayList();
        System.out.println(longList.getClass().equals(stringList.getClass())); //输出true
    }

    private static void testErasure(){
        try {
            List<Long> longList = Lists.newArrayList();
            longList.add(0L);    //此时泛型的实例为Long型，调用add方法只能存储Long型数据
            longList.getClass().getMethod("add", Object.class).invoke(longList, "12345");
            for (Object o : longList){
                System.out.println(o);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
