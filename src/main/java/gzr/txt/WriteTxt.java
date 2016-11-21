package gzr.txt;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by gaozengrong on 16/11/21.
 */
public class WriteTxt {
    public static void main(String[] args) {
        File fileName;
        FileWriter fw = null;
        try {
            fileName = new File("/Users/gaozengrong/Downloads/fileWriter.txt");
            fw = new FileWriter(fileName);
            for (int i = 0; i < 20; i++) {
                String context = "第" + (i + 1) + "次\n";
                fw.append(context);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (fw != null)
                    fw.close();// 关闭文件 只有关闭文件后 打开txt文件才能看到结果
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
