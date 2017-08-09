package gzr.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import gzr.object.Person;
import org.apache.commons.lang3.StringUtils;

/**
 * lambda表达式的一些语法糖
 *
 * @author zengrong.gzr
 * @date 2017/05/22
 */
public class ArrayAndList {
    public static void main(String[] args) {
        String str = "123,456,789,123,456, , ";
        String[] array = str.split(",");
        List<Object> list = stringToList(str, ",");
        System.out.println(list);
        System.out.println(listToString(list, "|"));
        List<Person> personList = new ArrayList<Person>();
        for (int i = 0; i < 3; i++) {
            Person temp = new Person();
            temp.setAge(i);
            temp.setName("gzr");
            temp.setSex("male");
            personList.add(temp);
        }
        System.out.println(objectListToString(personList));
    }

    /**
     * List转换为String
     *
     * @param list
     * @param delimiter
     */
    public static String listToString(List<Object> list, CharSequence delimiter) {
        return list.stream().filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(delimiter));
    }

    /**
     * String转换为List
     *
     * @param delimiter
     * @return
     */
    public static List<Object> stringToList(String str, CharSequence delimiter) {
        String[] array = str.split(String.valueOf(delimiter));
        //List<Long> value = Stream.of(array).filter(s -> !StringUtils.isBlank(s)).map(Long::parseLong).collect(Collectors.toList());
        return Stream.of(array).filter(s -> !StringUtils.isBlank(s)).collect(Collectors.toList());
    }

    /**
     * 对象数组拼成String
     *
     * @param personList
     * @return
     */
    public static String objectListToString(List<Person> personList) {
        return personList.stream().filter(Objects::nonNull)
            .map(p -> String.format("%s%s%s", p.getName(), p.getAge(), p.getSex()))
            .collect(Collectors.joining("#"));
    }
}
