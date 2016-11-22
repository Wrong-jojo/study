package gzr.date;

/**
 * Created by gaozengrong on 16/11/22.
 */
public class Calendar {
    public static void main(String[] args) {
        //获取第二天24点的时间
        java.util.Calendar endTime = java.util.Calendar.getInstance();
        endTime.add(java.util.Calendar.DATE,1);
        endTime.set(java.util.Calendar.HOUR_OF_DAY, 24);
//        endTime.set(java.util.Calendar.HOUR, 24);
        endTime.set(java.util.Calendar.MINUTE, 0);
        endTime.set(java.util.Calendar.SECOND, 0);
        endTime.set(java.util.Calendar.MILLISECOND, 0);
        System.out.println(endTime.getTime());
    }
}
