package gzr.Loader;

/**
 * 演示类加载器的树状组织结构
 * Created by gaozengrong on 16/12/20.
 */
public class ClassLoaderTree {
    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderTree.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }
    /*输出结果
    sun.misc.Launcher$AppClassLoader@9304b1
    sun.misc.Launcher$ExtClassLoader@190d11
    */
}
