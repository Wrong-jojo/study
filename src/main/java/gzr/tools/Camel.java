package gzr.tools;

/**
 * 驼峰命名和下划线命名互相转换
 *
 * @author zengrong.gzr
 * @date 2017/07/14
 */
public class Camel {
    public static void main(String[] args) {
        String camelStr = "camelToUnderline";
        System.out.println(camelToUnderline(camelStr));
        System.out.println(underlineToCamel(camelToUnderline(camelStr)));
    }

    public static String camelToUnderline(String camelStr) {
        if (camelStr == null) {
            return null;
        }
        String result = "";
        for (char c : camelStr.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result += "_" + Character.toLowerCase(c);
            } else {
                result += c;
            }
        }
        return result;
    }

    public static String underlineToCamel(String underlineStr) {
        if (underlineStr == null) {
            return null;
        }
        String result = "";
        boolean flag = false;
        for (char c : underlineStr.toCharArray()) {
            if (c == '_') {
                flag = true;
                continue;
            }
            if (flag) {
                c = Character.toUpperCase(c);
                flag = false;
            }
            result += c;
        }
        return result;
    }
}
