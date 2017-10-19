package gzr.beaninit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 静态方法注入
 *
 * @author zengrong.gzr
 * @date 2017/09/11
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"common-beans.xml"});
        System.out.println(StaticContextAccessor.staticField);
    }
}
