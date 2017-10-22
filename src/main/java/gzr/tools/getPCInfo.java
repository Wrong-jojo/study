package gzr.tools;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * 获取用户名等信息
 * Created by gaozengrong on 16/12/12.
 */
public class getPCInfo {
    public static void main(String[] args) throws UnknownHostException {
        Map< String,String> map = System.getenv();
        System.out.println(map);

        /*windows*/
        System.out.println(map.get("USERNAME"));//获取用户名
        System.out.println(map.get("COMPUTERNAME"));//获取计算机名
        System.out.println(map.get("USERDOMAIN"));//获取计算机域名

        /*mac*/
        System.out.println(map.get("USER"));

        System.out.println(InetAddress.getLocalHost().getHostAddress()); //获取本机ip
        System.out.println(Runtime.getRuntime().availableProcessors());  //当前机器cpu核数
    }
}
