package gzr.regexp;

import java.util.regex.Pattern;

/**
 * 拆分时间
 * Created by gaozengrong on 16/11/21.
 */
public class ConvertDeliverSpent {
    public static void main(String[] args) {
        String a=" 180sfdsgdsagsdaf";
        System.out.println(convertDeliverSpent(a));
    }

    private static String convertDeliverSpent(String param){
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        String num = p.matcher(param).replaceAll("").trim();
        Long deliverTime = Long.parseLong(num);
        int hour = (int) (deliverTime/60);
        int minute = (int) (deliverTime%60);
        if (hour == 0){
            return minute+"分钟送达";
        }else {
            if(minute == 0){
                return hour+"小时送达";
            }else {
                return hour+"小时"+minute+"分钟送达";
            }
        }
    }

}
