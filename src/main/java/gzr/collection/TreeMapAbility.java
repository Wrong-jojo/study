package gzr.collection;

import java.util.TreeMap;

/**
 * @author zengrong.gzr
 * @date 2017/04/01
 */
public class TreeMapAbility {
    public static void main(String[] args) {
        TreeMap<String,String> treeMap = new TreeMap<>();
        for (int i = 0; i < 3; i++) {
            treeMap.put(String.valueOf(0),String.valueOf(i));
            treeMap.put(String.valueOf(i),String.valueOf(i*i));
            treeMap.put(String.valueOf(i),String.valueOf(i*i*i));
        }
        System.out.println(treeMap);
    }
}
