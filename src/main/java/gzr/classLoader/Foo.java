package gzr.classLoader;

/**
 * Created by gaozengrong on 16/12/19.
 */
public class Foo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("gzr.classLoader.Foo", true,  Foo.class.getClassLoader());

        try {
            new Bar(String.valueOf(1));
        } catch (Throwable t) {
            t.printStackTrace();
        }

        try {
            new Bar(String.valueOf(1)); //will throw NoClassDefFoundError
        } catch (Throwable t) {
            t.printStackTrace();
        }

        try {
            new Bar(String.valueOf(1)); //will throw NoClassDefFoundError
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}

class Bar {
    private static String BAR_ID = getBarID();

    public Bar(String id) {
        BAR_ID = id;
    }

    private static String getBarID() {
        throw new RuntimeException("bar exception");
    }
}