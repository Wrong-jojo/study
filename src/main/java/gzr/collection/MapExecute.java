package gzr.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

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
        map.put("2", "next value");
        System.out.println(transMapToString(map));
        System.out.println(transStringToMap(transMapToString(map)));
    }

    /**
     * Map转换为String
     *
     * @param map
     * @return String 形如 username'chenziwen^password'1234
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

    /**
     * String转换为Map
     *
     * @param s 形如 username'chenziwen^password'1234
     * @return
     */
    public static Map<String, String> transStringToMap(String s) {
        if (StringUtils.isBlank(s)) {
            return new HashMap<>();
        }

        Map<String, String> map = new HashMap<String, String>();
        StringTokenizer st = new StringTokenizer(s, ",");

        while (st.hasMoreTokens()) {
            String kv = st.nextToken();
            // index of the key-value separator
            int kvSeparatorIndex = kv.indexOf("=");
            if (kvSeparatorIndex > 0) {
                String key = kv.substring(0, kvSeparatorIndex);
                String value = null;
                // deal IndexOutOfBound
                if (kvSeparatorIndex + 1 < kv.length()) {
                    value = kv.substring(kvSeparatorIndex + 1);
                } else {
                    value = "";
                }
                map.put(key, value);
            }
        }
        return map;
    }
}
