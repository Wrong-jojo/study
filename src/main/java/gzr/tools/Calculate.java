package gzr.tools;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author zengrong.gzr
 * @date 2019/09/29
 */
public class Calculate {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println(decimalFormat.format(new BigDecimal("0.123")));//Êä³ö0.12
        System.out.println(decimalFormat.format(new BigDecimal("12.00")));//Êä³ö12.00
        System.out.println(new BigDecimal(0.01).compareTo(new BigDecimal(0.00)));//Êä³ö12.00
        System.out.println("1.11".matches("^[0-9]+.[0][0]"));
    }
}
