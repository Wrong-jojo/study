package gzr.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zengrong.gzr
 * @date 2017/05/22
 */
public class MapExecute {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "initial value");
        Map<String, String> map2 = new HashMap<>();
        map.put("1", "change value");
        map.putAll(map2);
        System.out.println(map);
    }

    /**
     * 方法名称:transMapToString
     * 传入参数:map
     * 返回值:String 形如 username'chenziwen^password'1234
     */
    public static String transMapToString(Map map) {
        java.util.Map.Entry entry;
        StringBuilder sb = new StringBuilder();
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            entry = (java.util.Map.Entry)iterator.next();
            sb.append(entry.getKey().toString()).append("=").append(null == entry.getValue() ? "" :
                entry.getValue().toString()).append(iterator.hasNext() ? "," : "");
        }
        return sb.toString();
    }
}
