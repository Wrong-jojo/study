package gzr.proxy.remote;

import java.rmi.Naming;

/**
 * @author zengrong.gzr
 * @date 2017/03/13
 */
public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    public void go(){
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            String s = service.sayHello();
            System.out.println(s);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
