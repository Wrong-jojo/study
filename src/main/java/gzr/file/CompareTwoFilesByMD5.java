package gzr.file;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 通过比较两个文件的MD5码看文件是不是一样的
 * @author zengrong.gzr
 * @date 2017/04/03
 */
public class CompareTwoFilesByMD5 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        byte[] a = getMd5("/Users/gaozengrong/simpleExample/java/HelloWorld.class");
        byte[] b = getMd5("/Users/gaozengrong/simpleExample/HelloWorld.class");
        System.out.println(a.length == b.length);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.out.println(false);
            }
        }
    }

    /**
     * 获取文件的MD5码
     * @param filePath
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static byte[] getMd5(String filePath) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        try (InputStream is = Files.newInputStream(Paths.get(filePath));
             DigestInputStream dis = new DigestInputStream(is, md))
        {
          /* Read decorated stream (dis) to EOF as normal... */
        } catch (IOException e) {
            e.printStackTrace();
        }
        return md.digest();
    }
}
