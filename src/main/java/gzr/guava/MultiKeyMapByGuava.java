package gzr.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * two key map by guava
 *
 * @author gaozengrong
 * @date 2017/08/24
 */
public class MultiKeyMapByGuava {
    public static void main(String[] args) {
        //用guava的table实现
        Table<String, String, Integer> table = HashBasedTable.create();
        table.put("key1", "key2", 999);
        //输出999
        System.out.println(table.row("key1").values().iterator().next());
        //输出999
        System.out.println(table.column("key2").values().iterator().next());

    }
}
