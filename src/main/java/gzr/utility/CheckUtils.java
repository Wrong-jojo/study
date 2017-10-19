package gzr.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 校验函数 可以通过import static注入
 *
 * @author zengrong.gzr
 * @date 2017/08/13
 */
public class CheckUtils {
    public static boolean notNullAndGreaterThanZero(Integer i) {
        return Optional.ofNullable(i).orElse(0) > 0;
        //return i != null && i > 0;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        System.out.println(isEmpty(list));

    }

    /**
     * 校验Long、Integer、Short、long、int、short数值是否不为空且大于0
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> boolean nullOrLessThanZero(T t) {
        if (t == null) {
            return true;
        }
        //基本类型会被包装成对应的包装类
        if (Integer.class.equals(t.getClass())) {
            return (Integer)t <= 0;
        } else if (Short.class.equals(t.getClass())) {
            return (Short)t <= 0;
        } else if (Long.class.equals(t.getClass())) {
            return (Long)t <= 0;
        } else {
            throw new RuntimeException("error class type!param type must be Integer、Long or Short.");
        }
    }

    /**
     * 校验字符串是否为空 或者 长度比给定值长
     *
     * @param s         给定的字符串
     * @param maxLength 字符串允许的最大长度
     * @return
     */
    public static boolean emptyOrLonger(String s, int maxLength) {
        if (StringUtils.isBlank(s)) {
            return true;
        }
        s = s.trim();
        return s.trim().length() > maxLength;
    }

    /**
     * 判断字符串list是否为空 会过滤空字符串进行判断
     *
     * @param list
     * @return
     */
    public static Boolean isEmpty(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return true;
        }
        //取出空字符串后继续判空
        if (CollectionUtils.isEmpty(list.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList()))) {
            return true;
        }
        return false;
    }

}
