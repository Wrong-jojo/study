package gzr.proxy.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author zengrong.gzr
 * @Date 2017/03/13
 */
public interface MyRemote extends Remote{
    public String sayHello() throws RemoteException;
}
