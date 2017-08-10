package gzr.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import gzr.object.Chinese;
import gzr.object.Person;

/**
 * @author zengrong.gzr
 * @date 2017/08/10
 */
public class ObjectToObject {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        for (int i = 0; i < 3; i++) {
            Person temp = new Person();
            temp.setAge(i);
            temp.setName("gzr");
            temp.setSex("male");
            personList.add(temp);
        }
        List<Chinese> chineses = personList.stream().map(Chinese::joinChineseNationality).collect(Collectors.toList());
        System.out.println(chineses);
    }
}
