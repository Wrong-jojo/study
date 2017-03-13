package gzr.gsonAndJson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import gzr.object.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaozengrong on 16/12/11.
 */
public class GsonHelper {
    public static Gson gson=new Gson();

    public static void main(String[] args) {
        ListToGson();
    }

    private static void ListToGson(){
        System.out.println((Integer)null);
        Map<String,Object> map = new HashMap<String, Object>();
        List<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 3; i++) {
            Person temp = new Person();
            temp.setAge(i);
            temp.setName("gzr");
            list.add(temp);
        }
        map.put("full", gson.toJson(list));
        map.put("gzr","hahaha");
        String feature = gson.toJson(map);
//        Map resultMap = gson.fromJson(feature,new TypeToken<Map<String,Object>>(){}.getType());
//        System.out.println(resultMap);
//        List<Person> persons = gson.fromJson(resultMap.get("full").toString(), new TypeToken<List<Person>>(){}.getType());
        List<Person> persons = new ArrayList<Person>();
        persons = (List<Person>) getValueFromStringMap("full",feature,Person.class);
        System.out.println(persons);
        for (Person person:persons){
            System.out.println(person.getAge());
        }
    }

    public static <T> Object getValueFromStringMap(String key, String jsonStr, final Class<T> clazz){
        Map map = gson.fromJson(jsonStr,new TypeToken<Map<String,Object>>(){}.getType());
        List<T> temp = new ArrayList<T>();
//        return gson.fromJson(map.get(key).toString(),new TypeToken<List<Person>>(){}.getType());
        return gson.fromJson(map.get(key).toString(),new TypeToken<List<T>>(){}.getType());
    }
}
