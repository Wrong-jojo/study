package gzr.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat类
 * Created by gaozengrong on 16/12/15.
 */
public class SDF {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf.format(new Date()));  //输出20161215
    }
}
