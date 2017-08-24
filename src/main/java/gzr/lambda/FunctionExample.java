package gzr.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口
 *
 * @author zengrong.gzr
 * @date 2017/08/13
 */
public class FunctionExample {
    /**
     * 消费型接口
     *
     * @param money
     * @param consumer
     */
    public static void donation(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }

    /**
     * 供给型接口
     *
     * @param num
     * @param supplier
     * @return
     */
    public static List<Integer> supply(Integer num, Supplier<Integer> supplier) {
        List<Integer> resultList = new ArrayList<Integer>();
        for (int x = 0; x < num; x++) { resultList.add(supplier.get()); }
        return resultList;
    }

    /**
     * 函数型接口 转换字符串为Integer
     *
     * @param str
     * @param function
     * @return
     */
    public static Integer convert(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    /**
     * 断言型接口 筛选出只有2个字的水果
     *
     * @param fruit
     * @param predicate
     * @return
     */
    public static List<String> filter(List<String> fruit, Predicate<String> predicate) {
        List<String> f = new ArrayList<>();
        for (String s : fruit) {
            if (predicate.test(s)) {
                f.add(s);
            }
        }
        return f;
    }

    public static void main(String[] args) {
        donation(1000, money -> System.out.println("好心的麦乐迪为Blade捐赠了" + money + "元"));

        List<Integer> list = supply(10, () -> (int)(Math.random() * 100));
        list.forEach(System.out::println);

        Integer value = convert("28", x -> Integer.parseInt(x));

        List<String> fruit = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
        List<String> newFruit = filter(fruit, (f) -> f.length() == 2);
        System.out.println(newFruit);
    }
}
