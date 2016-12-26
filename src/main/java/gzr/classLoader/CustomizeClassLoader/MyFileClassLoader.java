package gzr.classLoader.CustomizeClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 自己定制一个ClassLoader 需要实现ClassLoader的findClass()方法
 * Created by gaozengrong on 16/12/26.
 */
public class MyFileClassLoader extends ClassLoader{

    @Override
    public Class findClass(String name) {
        byte[] data = loadClassData(name);
        return defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        FileInputStream fis = null;
        byte[] data = null;
        try {
            fis = new FileInputStream(new File("/Users/gaozengrong/gzr/study/target/classes/gzr/classLoader/CustomizeClassLoader/MyApp.class"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int ch = 0;
            while ((ch = fis.read()) != -1) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
