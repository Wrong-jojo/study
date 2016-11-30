package gzr.Proxy.Dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK鍔ㄦ�佷唬鐞嗕唬鐞嗙被  鍏蜂綋鍙互鍙傝��,鍐欑殑寰堝ソ [InvocationHandler涓璱nvoke()鏂规硶鐨勮皟鐢ㄩ棶棰榏(http://paddy-w.iteye.com/blog/841798)
 * Created by gaozengrong on 16/11/28.
 */
public class DynamicProxy implements InvocationHandler {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        //鍙栧緱浠ｇ悊瀵硅薄
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);  //瑕佺粦瀹氭帴鍙�(杩欐槸涓�涓己闄凤紝cglib寮ヨˉ浜嗚繖涓�缂洪櫡)
    }

    /**
     * 璋冪敤鏂规硶
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("浜嬪姟寮�濮�");
        //鎵ц鏂规硶
        result = method.invoke(target, args);
        System.out.println("浜嬪姟缁撴潫");
        return result;
    }
}
