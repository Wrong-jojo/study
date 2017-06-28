package gzr.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gaozengrong on 16/12/27.
 */
public class ListAndArray {
    public static void main(String[] args) {
        listToArray();
        arrayToList();
    }

    private static void listToArray() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        String[] strings = list.toArray(new String[0]);
        System.out.println("strings's class is " + strings.getClass());
        System.out.println(strings);
        System.out.println("String's class is" + String.class);
        System.out.println(Arrays.toString(strings));
    }

    private static void arrayToList() {
        String[] array = {"1", "2"};
        List<String> list = Arrays.asList(array);
        System.out.println(list);
    }
}
