package gzr.collection;

import java.util.Set;

import org.apache.commons.collections.SetUtils;

/**
 * @author zengrong.gzr
 * @date 2017/05/20
 */
public class EmptyCollection {
    public static void main(String[] args) {
        Set<String> set = SetUtils.EMPTY_SET;
        //add的时候会抛出异常
        set.add("123");
    }
}
