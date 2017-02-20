package gzr.annotation.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by gaozengrong on 17/1/5.
 */
public class Run {
    public static void main(String[] args) throws Exception {

        System.out.println("Testing...");

        int passed = 0, failed = 0, count = 0, ignore = 0;

        Class<Example> obj = Example.class;

        // Process @TesterInfo   isAnnotationPresent()判断注解类是不是当前类的注解
        if (obj.isAnnotationPresent(ClassAnnotation.class)) {

            Annotation annotation = obj.getAnnotation(ClassAnnotation.class);
            ClassAnnotation classAnnotation = (ClassAnnotation) annotation;

            System.out.printf("%nPriority :%s", classAnnotation.priority());
            System.out.printf("%nCreatedBy :%s", classAnnotation.createdBy());
            System.out.printf("%nTags :");

            int tagLength = classAnnotation.tags().length;
            for (String tag : classAnnotation.tags()) {
                if (tagLength > 1) {
                    System.out.print(tag + ", ");
                } else {
                    System.out.print(tag);
                }
                tagLength--;
            }

            System.out.printf("%nLastModified :%s%n%n", classAnnotation.lastModified());

        }

        // Process @Test
        for (Method method : obj.getDeclaredMethods()) {

            // if method is annotated with @Test
            if (method.isAnnotationPresent(MethodAnnotation.class)) {

                Annotation annotation = method.getAnnotation(MethodAnnotation.class);
                MethodAnnotation test = (MethodAnnotation) annotation;

                // if enabled = true (default)
                if (test.enabled()) {

                    try {
                        method.invoke(obj.newInstance());
                        System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
                        passed++;
                    } catch (Throwable ex) {
                        System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
                        failed++;
                    }

                } else {
                    System.out.printf("%s - Test '%s' - ignored%n", ++count, method.getName());
                    ignore++;
                }

            }

        }
        System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);

    }
}
