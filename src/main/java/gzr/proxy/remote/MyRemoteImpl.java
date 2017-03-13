package gzr.proxy.remote;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author zengrong.gzr
 * @Date 2017/03/13
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{

    // UnicastRemoteobject 实现了某些"远程功能"。其构造方法抛出了RemoteException异常
    protected MyRemoteImpl() throws RemoteException{
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says 'Hey'";
    }

    public static void main(String[] args) {
        System.out.println("服务启动！");
        try{
            MyRemote service = new MyRemoteImpl();
            //将指定名称重新绑定到一个新的远程对象
            Naming.rebind("RemoteHello", service);
        }catch (Exception e){

        }
    }
}
