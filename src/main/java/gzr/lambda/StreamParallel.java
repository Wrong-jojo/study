package gzr.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import gzr.object.ShopProperty;

/**
 * @author zengrong.gzr
 * @date 2017/08/13
 */
public class StreamParallel {
    public static void main(String[] args) throws Exception {
        ShopProperty p1 = new ShopProperty("叫了个鸡", 1000, 500, 2);
        ShopProperty p2 = new ShopProperty("张三丰饺子馆", 2300, 1500, 3);
        ShopProperty p3 = new ShopProperty("永和大王", 580, 3000, 1);
        ShopProperty p4 = new ShopProperty("肯德基", 6000, 200, 4);
        List<ShopProperty> properties = Arrays.asList(p1, p2, p3, p4);
        // Stream操作

        //找出距离我最近的店铺
        String name = properties.stream()
            .sorted(Comparator.comparingInt(ShopProperty::getDistance))
            .findFirst()
            .orElseThrow(() -> new Exception("can't find the nearest shop.")).getName();
        System.out.println("距离我最近的店铺是:" + name);

        //找出所有销量大于1000的店铺 并计算出店铺个数
        long count = properties.stream()
            .filter(p -> p.getSales() > 1000)
            .count();


        //调用parallelStream并行处理
        List<String> names = properties.parallelStream()
            .filter(p -> p.getPriceLevel() < 4)
            .sorted(Comparator.comparingInt(ShopProperty::getDistance))
            .map(ShopProperty::getName)
            .limit(2)
            .collect(Collectors.toList());

        flatMap();
    }

    /**
     * 提取子流的操作
     */
    public static void flatMap() {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("apple", "click"));
        lists.add(Arrays.asList("boss", "dig", "qq", "vivo"));
        lists.add(Arrays.asList("c#", "biezhi"));
        System.out.println(lists.stream()
            .flatMap(Collection::stream)
            .filter(str -> str.length() > 2)
            .count());
    }

}
