package gzr.tools;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;

/**
 * Created by gaozengrong on 16/11/30.
 */
public class GBKToUTF8 {
    public static void main(String[] args) throws Exception {

        String gbkDirPath = "/Users/gaozengrong/gzr/study/src";//GBK编码格式源码文件路径
        String utf8DirPath = "/Users/gaozengrong/copy/study/src";//转为UTF-8编码格式源码文件保存路径

        @SuppressWarnings("unchecked")
        Collection<File> gbkFileList =  FileUtils.listFiles(new File(gbkDirPath), new String[]{"java"}, true);//获取所有java文件
        for (File gbkFile : gbkFileList) {
            String utf8FilePath = utf8DirPath + gbkFile.getAbsolutePath().substring(gbkDirPath.length());//UTF-8编码格式文件保存路径
            FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(gbkFile, "GBK"));//使用GBK编码格式读取文件，然后用UTF-8编码格式写入数据
        }
    }
}
