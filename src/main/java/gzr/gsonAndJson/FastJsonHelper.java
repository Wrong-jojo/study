package gzr.gsonAndJson;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import gzr.object.Person;

/**
 * @author zengrong.gzr
 * @date 2017/04/06
 */
public class FastJsonHelper {
    public static void main(String[] args) {
        Girl girl = new Girl();
        girl.setAge(18);
        girl.setName("Mary");
        girl.setSex("female");
        //输出 {"name":"Mary","sex":"female"}   只会输出getter方法对应的字段
        String girlStr = JSON.toJSONString(girl);
        System.out.println("JSON.toJSONString girl: " + girlStr);
        Girl copyGirl = JSON.parseObject(girlStr, Girl.class);
        System.out.println("origin girl: " + girl);
        System.out.println("copy girl: " + copyGirl);

        whenKeyIsNum();
        antiAnalysisToMap();
        disableCircularReference();
    }

    /**
     * 当key为数字时,json序列化后出错
     * https://github.com/alibaba/fastjson/issues/66
     */
    public static void whenKeyIsNum() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1512, "手机");
        map.put(1101, "笔记本电脑");
        //输出  {1101:"笔记本电脑",1512:"手机"}
        System.out.println(JSON.toJSONString((map), SerializerFeature.QuoteFieldNames));
        //输出  {"1512":"手机","1101":"笔记本电脑"}
        System.out.println(JSON.toJSONString((map), SerializerFeature.WriteNonStringKeyAsString));
    }

    /**
     * 反解析到 Map<String, Object> 这种数据结构
     */
    public static void antiAnalysisToMap() {
        String s = "{\"1512\":\"手机\",\"1101\":\"笔记本电脑\"}";
        Map<Long, String> map = JSON.parseObject(s, new TypeReference<Map<Long, String>>() {});
        //输出  {1=gzr.object.Person@1175e2db[age=20,name=gao,sex=male], 2=gzr.object.Person@1175e2db[age=20,name=gao,sex=male]}
        System.out.println(JSON.toJSONString((map),SerializerFeature.DisableCircularReferenceDetect));
    }

    /**
     * 消除循环引用
     */
    public static void disableCircularReference() {
        Person person = new Person(20, "gao", "male");
        Map<Long, Person> map = new HashMap<>();
        map.put(1L,person);
        map.put(2L,person);
        //输出  {1512=手机, 1101=笔记本电脑}
        System.out.println(map);
    }
}
