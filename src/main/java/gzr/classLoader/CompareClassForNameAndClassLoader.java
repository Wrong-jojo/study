package gzr.classLoader;

/**
 * Class.forName和classloader的区别：
 * class.forName()除了将类的.class文件加载到jvm中之外，还会对类进行解释，执行类中的static块。
 * 而classLoader只干一件事情，就是将.class文件加载到jvm中，不会执行static中的内容,只有在newInstance才会去执行static块。
 * Class.forName(name, initialize, loader)带参函数也可控制是否加载static块。并且只有调用了newInstance()方法采用调用构造函数，创建类的对象
 */
class Point {
    static {
        System.out.println("execute Point's static code.");
    }

    Point(){
        System.out.println("execute Point's constructer.");
    }

    int x, y;
}

class Line {
    static {
        System.out.println("execute Line's static code.");
    }

    Line(){
        System.out.println("execute Line's constructer.");
    }
}

class Compare {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader is " + systemClassLoader);

        System.out.println("--------使用Class.forName()加载类--------");
        //全路径
        String wholeNamePoint = "gzr.classLoader.Point";
        //使用Class类的forName()静态方法--类的全路径
        try {
            System.out.println(String.format("before execute Class.forName(%s)",wholeNamePoint));
            Class point = Class.forName(wholeNamePoint);
            System.out.println(String.format("after execute Class.forName(%s)",wholeNamePoint));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--------使用Class类的ClassLoader加载类--------");
        //测试使用ClassLoader的反射方式来获得该类对应的Class对象
        String wholeNameLine = "gzr.classLoader.Line";
        Class<?> demo = null;
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            System.out.println(String.format("before execute ClassLoader.loadClass(%s)",wholeNameLine));
            demo = loader.loadClass(wholeNameLine);
            //demo = ClassForNameAndClassLoaderTest.class.getClassLoader().loadClass(wholeNameLine);//这个也是可以的
            System.out.println(String.format("after execute ClassLoader.loadClass(%s)",wholeNameLine));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("--------使用Class.newInstance()创建实例--------");
        //若下面这个try catch 注释掉则不会打印 loading Line
        try {
            //是因为上面可能会异常，demo可能会是null,所以直接demo.newInstance()可能会空指针异常
            //测试什么时候执行类中的静态代码
            System.out.println("before execute Class.newInstance()");
            Line line = (Line) (demo != null ? demo.newInstance() : null);
            System.out.println("after execute Class.newInstance()");
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}