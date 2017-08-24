package gzr.network.cs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 客户端
 *
 * @author zengrong.gzr
 * @date 2017/08/24
 */
public class Client {
    public static void main(String args[]) throws IOException {
        Socket conn = new Socket("127.0.0.1", 7002);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        bw.write("hello\n");
        bw.flush();
        String s = br.readLine();
        System.out.println(s);

        bw.write("world\n");
        bw.flush();
        s = br.readLine();
        System.out.println(s);

        br.close();
        bw.close();
        conn.close();
    }
}
