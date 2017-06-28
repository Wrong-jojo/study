package gzr.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

/**
 * lambda表达式的一些语法糖
 * @author zengrong.gzr
 * @date 2017/05/22
 */
public class ArrayAndList {
    public static void main(String[] args) {
        String str = "123,456,789,123,456, , ";
        String[] array = str.split(",");
        List<Long> value = Stream.of(array).filter(s -> !StringUtils.isBlank(s)).map(Long::parseLong).collect(Collectors.toList());
        System.out.println(value);
    }
}
