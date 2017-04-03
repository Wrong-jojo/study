package gzr.file;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.jar.Manifest;

/**
 * 连接到jar文件并读取manifest文件
 * @author zengrong.gzr
 * @date 2017/03/22
 */
public class ConnectToJarFile {
    public static void main(String[] args) throws IOException {
        //必须是绝对路径 如果是~/IdeaProjects的形式会出错
        URL url = new URL("jar:file:/Users/gaozengrong/IdeaProjects/helloworld/target/helloworld-1.0-SNAPSHOT.jar!/");
        JarURLConnection jarConnection = (JarURLConnection)url.openConnection();
        Manifest manifest = jarConnection.getManifest();
        System.out.println(manifest);
    }
}

