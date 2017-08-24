package gzr.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;

/**
 * @author zengrong.gzr
 * @date 2017/08/24
 */
public class TcpServer {
    public static void main(String[] args) throws ParseException {
        try {
            //浏览器请求http://localhost:8080/index.jsp即可
            ServerSocket ss = new ServerSocket(8080);
            Socket socket = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String s = null;
            while ((s = br.readLine()) != null && !s.equals("")) { System.out.println(s); }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("HTTP/1.1 200 OK\n");
            bw.write("Content-Type: text/html; charset=UTF-8\n\n");
            bw.write("<html>\n" +
                "<head>\n" +
                "    <title>first page</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Hello World!</h1>\n" +
                "</body>\n" +
                "</html>\n");
            bw.flush();

            br.close();
            bw.close();
            socket.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
