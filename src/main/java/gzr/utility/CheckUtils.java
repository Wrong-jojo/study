package gzr.utility;

import java.util.Optional;

/**
 * @author zengrong.gzr
 * @date 2017/08/13
 */
public class CheckUtils {
    public static boolean notNullAndGreaterThanZero(Integer i) {
        return Optional.ofNullable(i).orElse(0) > 0;
        //return i != null && i > 0;
    }

    public static void main(String[] args) {
        System.out.println(Optional.ofNullable(null));
        System.out.println(notNullAndGreaterThanZero(1));
    }
}
