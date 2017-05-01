package gzr.guava.eventBus;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.common.eventbus.EventBus;

/**
 * Created by gaozengrong on 16/11/22.
 */
public class EventBusChat {
    public static void main(String[] args) {
        EventBus channel = new EventBus();
        ServerSocket socket;
        try {
            socket = new ServerSocket(4444);
            while (true) {
                //等待请求,此方法会一直阻塞,直到获得请求才往下走 telnet 127.0.0.1 4444
                Socket connection = socket.accept();
                UserThread newUser = new UserThread(connection, channel);
                channel.register(newUser);
                System.out.println("start");
                newUser.start();
                System.out.println("end");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
