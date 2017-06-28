package gzr.guava;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by gaozengrong on 16/11/21.
 */
public class Fluent {
    public static void main(String[] args) {
        String s = "123,456, 123,,";
        System.out.println(convertStringListToLongList(s));
    }

    private  static List<Long> convertStringListToLongList(String para){
        List<String> list = Splitter.on(',').splitToList(para.trim());
        return FluentIterable.from(list).transform(new Function<String, Long>() {
            @Override
            public Long apply(String input) {
                if (StringUtils.isBlank(input)){
                    // ""和null都进行过滤
                    return null;
                }
                try {
                    return Long.valueOf(input.trim());
                }catch (Exception e){
                    // 不能转化为Long的字符串也进行过滤
                    return null;
                }
            }
        }).filter(Predicates.<Long>notNull()).toList();
    }
}
