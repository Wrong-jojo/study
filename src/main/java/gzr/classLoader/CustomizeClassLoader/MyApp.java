package gzr.classLoader.CustomizeClassLoader;


/**
 * Created by gaozengrong on 16/12/26.
 */
public class MyApp {
    public static void main(String[] args) throws Exception {
        MyFileClassLoader loader = new MyFileClassLoader();
        Class objClass = loader.findClass("gzr.classLoader.CustomizeClassLoader.MyApp");
        Object obj = objClass.newInstance();
        System.out.println(objClass.getName());
        System.out.println(objClass.getClassLoader());
        System.out.println(obj);
    }
}
