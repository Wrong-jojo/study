package gzr.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zengrong.gzr
 * @date 2017/12/17
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {"spring-cache.xml"});
        AccountService accountService = (AccountService)appContext.getBean("accountService");
        accountService.getAccountByName("gzr");
        accountService.getAccountByName("gzr");
    }
}
