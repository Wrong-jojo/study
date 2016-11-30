package gzr.Proxy.Cglib;

import org.junit.Test;

/**
 * Created by gaozengrong on 16/11/29.
 */
public class CglibProxyTest {
    @Test
    public void testCglibProxy(){
        CglibProxy cglibProxy = new CglibProxy();
        BookFacadeImpl1 bookFacadeImpl1 = (BookFacadeImpl1) cglibProxy.getInstance(new BookFacadeImpl1());
        bookFacadeImpl1.addBook();
    }
}
