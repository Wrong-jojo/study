package gzr.guava;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Multimaps;
import com.sun.istack.internal.Nullable;
import gzr.object.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaozengrong on 16/11/22.
 */
public class Multimap {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 5; i++) {
            Person temp = new Person();
            temp.setAge(i);
            temp.setName("123");
            list.add(temp);
        }
        Person temp = new Person();
        temp.setAge(1);
        temp.setName("345");
        list.add(temp);
        System.out.println(JSONObject.toJSON(list));

        ImmutableListMultimap<Integer, Person> map = Multimaps.index(list, new Function<Person, Integer>() {
            @Nullable
            @Override
            public Integer apply(@Nullable Person input) {
                assert input != null;
                return input.getAge();
            }
        });
        //key为1的情况下 value有两个值
        System.out.println(JSONObject.toJSON(map.get(1))); //输出[{"name":"123","age":1},{"name":"345","age":1}]
    }
}
