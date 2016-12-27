package gzr.classLoader.CustomizeClassLoader;


/**
 * MyFileClassLoader加载MyFileClassLoader.class
 * Created by gaozengrong on 16/12/26.
 */
public class MyApp {
    static {
        System.out.println("execute MyApp's static code");
    }

    public static void main(String[] args) throws Exception {
        MyFileClassLoader loader = new MyFileClassLoader();
        System.out.println("before execute MyFileClassLoader.findClass()");
        Class objClass = loader.findClass("gzr.classLoader.CustomizeClassLoader.MyApp");
        System.out.println("after execute MyFileClassLoader.findClass()");

        System.out.println("loaded Class name is " + objClass.getName());

        System.out.println("before execute Class.newInstance()");
        //执行newInstance时会执行static块
        Object obj = objClass.newInstance();
        System.out.println("after execute Class.newInstance()");

        System.out.println("ClassLoader is " + objClass.getClassLoader());
        System.out.println("object is "+ obj);
    }
}
