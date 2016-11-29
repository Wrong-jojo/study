package gzr.Proxy.Static;

import org.junit.Test;

/**
 * ≤‚ ‘Count¿‡
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