package gzr.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则捕获组
 * @author zengrong.gzr
 * @date 2017/03/23
 */
public class CaptureGroup {
    public static void main(String[] args) {
        String regEx = "\"activityId\":((\\s|\\d)+),";
        String s = "{\n"
            + "\"activitySchema\":\"1.0.0\",\"activityId\":714 80 042,\"name\":\"ljj凑单4\",\"description\":\"ljj凑单4\","
            + "\"type\":\"PRIVATE\",\"participateRange\":\"GROUP\",\"options\":4,\"target\":null,"
            + "\"startTime\":\"2017-03-18 00:00:00\",\"endTime\":\"2017-03-25 23:59:59\",\"status\":\"NORMAL\","
            + "\"operation\":[{\n";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        if (m.find()) {
            System.out.println(m.group(1).replaceAll(" ",""));
        }
    }
}
