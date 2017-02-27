package gzr.Proxy.Dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理代理类  具体可以参考,写的很好 [InvocationHandler中invoke()方法的调用问题](http://paddy-w.iteye.com/blog/841798)
 * Created by gaozengrong on 16/11/28.
 */
public class DynamicProxy implements InvocationHandler{
    private Object target;

    public Object bind(Object target){
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);  //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
        /**
         Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)做了以下几件事.
        （1）根据参数loader和interfaces调用方法 getProxyClass(loader, interfaces)创建代理类$Proxy0.$Proxy0类 实现了interfaces的接口,并继承了Proxy类.
        （2）实例化$Proxy0并在构造方法中把DynamicProxy传过去,接着$Proxy0调用父类Proxy的构造器,为h赋值,如下：
         */
    }
    /**
     * 调用方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("事务开始");
        //执行方法
        result=method.invoke(target, args);
        System.out.println("事务结束");
        return result;
    }
}
