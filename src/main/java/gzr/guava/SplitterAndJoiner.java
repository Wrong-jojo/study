package gzr.guava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * 将List转换为逗号分隔符
 * Created by gaozengrong on 16/12/9.
 */
public class SplitterAndJoiner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        System.out.println();

        long startTime = System.currentTimeMillis();
        stringToList();
        long endTime = System.currentTimeMillis();
        System.out.println("StringToList()函数运行时间： " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        listToString();
        endTime = System.currentTimeMillis();
        System.out.println("ListToString()函数运行时间： " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();

        startTime = System.currentTimeMillis();
        stringToMap();
        endTime = System.currentTimeMillis();
        System.out.println("stringToMap()函数运行时间： " + (endTime - startTime) + "ms");
    }

    private static void stringToList() {
        String str = "a, b, c";
        List<String> result = Splitter.on(",").trimResults().splitToList(str);
        System.out.println(result); //输出[a, b, c]
    }

    private static void listToString() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        String str = Joiner.on(",").useForNull("").join(list);
        System.out.println(str);  //输出a,b,c
    }

    private static void stringToMap() {
        String s = "name=gaozengrong,age=26,height=178";
        Map<String, String> map = Splitter.on(',').withKeyValueSeparator('=').split(s);
        System.out.println(map);
    }

}
