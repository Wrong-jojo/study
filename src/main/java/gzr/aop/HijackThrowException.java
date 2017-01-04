package gzr.aop;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created by gaozengrong on 17/1/4.
 */
public class HijackThrowException implements ThrowsAdvice{
    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("HijackThrowException : Throw exception hijacked!");
    }
}
