package gzr.Proxy.StaticProxy;

import org.junit.Test;

/**
 * 测试Count类
 * Created by gaozengrong on 16/11/28.
 */
public class CountTest {
    @Test
    public void testCount() throws Exception {
        CountImpl countImpl = new CountImpl();
        CountProxy countProxy = new CountProxy(countImpl);
        countProxy.updateCount();
        countProxy.queryCount();
    }
}
