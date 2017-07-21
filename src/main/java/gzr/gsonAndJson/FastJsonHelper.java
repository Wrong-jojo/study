package gzr.gsonAndJson;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

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
    }

    /**
     * 当key为数字时,json序列化后出错
     * https://github.com/alibaba/fastjson/issues/66
     */
    public static void whenKeyIsNum(){
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1512, "手机");
        map.put(1101, "笔记本电脑");
        //输出  {1101:"笔记本电脑",1512:"手机"}
        System.out.println(JSON.toJSONString((map), SerializerFeature.QuoteFieldNames));
        //输出  {"1512":"手机","1101":"笔记本电脑"}
        System.out.println(JSON.toJSONString((map), SerializerFeature.WriteNonStringKeyAsString));

    }
}
