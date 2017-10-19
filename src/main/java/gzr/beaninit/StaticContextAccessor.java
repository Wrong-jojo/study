package gzr.beaninit;

/**
 * @author zengrong.gzr
 * @date 2017/09/11
 */
public class StaticContextAccessor {
    public static String staticField;

    public static void setStaticField(String staticField) {
        StaticContextAccessor.staticField = staticField;
    }
}
