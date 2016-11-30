package gzr.tools;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;

/**
 * 灏咷BK缂栫爜鏍煎紡鐨勬枃浠惰浆鎹负UTF-8缂栫爜鏍煎紡鐨勬枃浠�
 * Created by gaozengrong on 16/11/30.
 */
public class GBKToUTF8 {
    public static void main(String[] args) throws Exception {

        String gbkDirPath = "/Users/gaozengrong/gzr/study/src";//GBK缂栫爜鏍煎紡婧愮爜鏂囦欢璺緞
        String utf8DirPath = "/Users/gaozengrong/gzr/copy/src";//杞负UTF-8缂栫爜鏍煎紡婧愮爜鏂囦欢淇濆瓨璺緞

        @SuppressWarnings("unchecked")
        Collection<File> gbkFileList =  FileUtils.listFiles(new File(gbkDirPath), new String[]{"java"}, true);//鑾峰彇鎵�鏈塲ava鏂囦欢
        for (File gbkFile : gbkFileList) {
            String utf8FilePath = utf8DirPath + gbkFile.getAbsolutePath().substring(gbkDirPath.length());//UTF-8缂栫爜鏍煎紡鏂囦欢淇濆瓨璺緞
            FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(gbkFile, "GBK"));//浣跨敤GBK缂栫爜鏍煎紡璇诲彇鏂囦欢锛岀劧鍚庣敤UTF-8缂栫爜鏍煎紡鍐欏叆鏁版嵁
        }
    }

}

