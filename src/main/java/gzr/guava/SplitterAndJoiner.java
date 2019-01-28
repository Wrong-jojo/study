package gzr.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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
        System.out.println(stringToMap("name=gaozengrong,age=26,height=178", ",", "="));
        endTime = System.currentTimeMillis();
        System.out.println("stringToMap()函数运行时间： " + (endTime - startTime) + "ms");
    }

    private static void stringToList() {
        String str = "a, b, c";
        List<String> result = Splitter.on(Pattern.compile(",|;")).trimResults().splitToList(str);
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

    public static void stringToMap() {
        String s = "name=gaozengrong,age=26,height=178";
        Map<String, String> map = Splitter.on(',').withKeyValueSeparator('=').split(s);
        System.out.println(map);
    }

    /**
     * String转换为Map
     *
     * @param s
     * @param separator
     * @param kvSeparator
     * @return
     */
    public static Map stringToMap(String s, String separator, String kvSeparator) {
        return Splitter.on(separator).withKeyValueSeparator(kvSeparator).split(s);
    }

    /**
     * Map转换为String
     *
     * @param map
     * @param separator
     * @param kvSeparator
     * @return
     */
    public static String MapToString(Map map, String separator, String kvSeparator) {
        return Joiner.on(separator).withKeyValueSeparator(kvSeparator).useForNull("").join(map);
    }
}
