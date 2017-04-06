package gzr.gsonAndJson;

import com.alibaba.fastjson.JSON;

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
        System.out.println(JSON.toJSONString(girl));
    }
}
