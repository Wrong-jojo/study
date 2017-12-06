package gzr.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import com.google.common.base.Splitter;

/**
 * Created by gaozengrong on 16/11/21.
 */
public class ReadTxt {
    public static void main(String[] args) {
        String s;
        try {
            BufferedReader input = new BufferedReader(new FileReader("/Users/gaozengrong/Downloads/排序转换成逗号的itemIds.txt")); //读取流
            s = input.readLine();
            List<String> itemIds = Splitter.on(",").splitToList(s.trim());
            System.out.println(itemIds.size());
            //            while((s = input.readLine())!=null){ //判断是否读到了最后一行
            //                String info[] = s.split("\t");
            //                System.out.println("门店id:"+info[0]+"活动id:"+info[1]+"门店类型:"+info[2]+"添加/删除:"+info[3]);
            //            }
            input.close();
        } catch (Exception ignored) {

        }
    }

    /**
     * 加载文件
     *
     * @param filePath 文件路径
     * @return 文件所有内容
     */
    public static StringBuilder loadFile(String filePath) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String input;
            while ((input = reader.readLine()) != null) {
                builder.append(input);
                builder.append('\n');
            }
        } catch (Exception ignored) {

        }
        return builder;

    }
}
