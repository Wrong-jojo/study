package gzr.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by gaozengrong on 17/1/4.
 */
public class HijackAfterMethod implements AfterReturningAdvice{
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("HijackAfterMethod : After method hijacked!");
    }
}
