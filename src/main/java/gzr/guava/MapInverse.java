package gzr.guava;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author zengrong.gzr
 * @date 2017/12/07
 */
public class MapInverse {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "gzr");
        System.out.println(map);
        System.out.println(inverseMap(map));
    }

    /**
     * 翻转map
     *
     * @param map
     * @param <M>
     * @param <N>
     * @return
     */
    public static <M, N> Map<N, M> inverseMap(Map<M, N> map) {
        BiMap<M, N> biMap = HashBiMap.create();
        biMap.putAll(map);
        return biMap.inverse();
    }
}
