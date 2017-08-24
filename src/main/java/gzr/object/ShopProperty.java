package gzr.object;

import lombok.Getter;
import lombok.Setter;

/**
 * 外卖店铺属性
 * @author zengrong.gzr
 * @date 2017/08/13
 */
@Getter
@Setter
public class ShopProperty {
    private String name;
    // 距离，单位:米
    private Integer distance;
    // 销量，月售
    private Integer sales;
    // 价格，这里简单起见就写一个级别代表价格段
    private Integer priceLevel;

    public ShopProperty(String name, int distance, int sales, int priceLevel) {
        this.name = name;
        this.distance = distance;
        this.sales = sales;
        this.priceLevel = priceLevel;
    }
}
