package gzr.Loader;

/**
 * Created by gaozengrong on 16/12/19.
 */
public class Foo {
    public static void main(String[] args) {
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
        this.BAR_ID = id;
    }

    private static String getBarID() {
        throw new RuntimeException("bar exception");
    }
}