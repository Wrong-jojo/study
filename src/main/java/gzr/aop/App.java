package gzr.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        //Spring AOP Advice，Class（CustomerService）中的全部method都被自动的拦截
//        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-AOP-Advice.xml" });
        //利用Pointcuts拦截部分方法
        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-AOP-Advisor.xml" });

        CustomerService cust = (CustomerService) appContext.getBean("customerServiceProxy");

        System.out.println("使用Spring AOP 如下");
        System.out.println("*************************");
        cust.printName();
        System.out.println("*************************");
        cust.printURL();
        System.out.println("*************************");

        try {
            cust.printThrowException();
        } catch (Exception e) {

        }

    }

}