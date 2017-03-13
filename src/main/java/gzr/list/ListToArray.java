package gzr.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gaozengrong on 16/12/27.
 */
public class ListToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        String[] strings = list.toArray(new String[0]);
        System.out.println("strings's class is " + strings.getClass());
        System.out.println(strings);
        System.out.println("String's class is" + String.class);
        System.out.println(Arrays.toString(strings));
    }
}
