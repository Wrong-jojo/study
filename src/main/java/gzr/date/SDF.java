package gzr.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat类
 * Created by gaozengrong on 16/12/15.
 */
public class SDF {
    public static void main(String[] args) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHH");  //HH 24小时制
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhh"); //hh 12小时制
        System.out.println(convertDateToString(new Date(), sdf1));  //输出2017011804

        String date = "2017-01-19 16:49:55";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //HH 24小时制
        try {
            System.out.println(convertStringToDate(date,sdf2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * 字符串转日期
     * @param s
     * @param sdf
     * @return
     * @throws ParseException
     */
    static Date convertStringToDate(String s, SimpleDateFormat sdf) throws ParseException {
        return sdf.parse(s);
    }

    /**
     * 字符串转日期
     * @param date
     * @param sdf
     * @return
     */
    static String convertDateToString(Date date, SimpleDateFormat sdf){
        return sdf.format(date);
    }
}
