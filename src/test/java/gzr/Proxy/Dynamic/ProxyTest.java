package gzr.Proxy.Dynamic;

import gzr.Proxy.Static.Count;
import gzr.Proxy.Static.CountImpl;
import org.junit.Test;

/**
 * Created by gaozengrong on 16/11/28.
 */
public class ProxyTest {
    @Test
    public void testBookFacadeProxy(){
        DynamicProxy proxy = new DynamicProxy();
        BookFacade bookFacade = (BookFacade) proxy.bind(new BookFacadeImpl());
        System.out.println(bookFacade.getClass().getName());
        bookFacade.addBook();
    }

    @Test
    public void testCountProxy(){
        DynamicProxy proxy = new DynamicProxy();
        Count count = (Count) proxy.bind(new CountImpl());
        System.out.println(count.getClass().getName());
        count.queryCount();
//        count.updateCount();
    }


}