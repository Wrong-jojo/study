package gzr.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gaozengrong on 17/1/5.
 */
@Target(ElementType.TYPE) //针对class、interface、enum的注解
@Retention(RetentionPolicy.RUNTIME) //运行时获得
public @interface TestAnnotation {
    int count() default 1;
}
