package gzr.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zengrong.gzr
 * @date 2017/08/21
 */
public class ThreadLocalDemo implements Runnable{
    // threadlocal variable is created
    public static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue(){
            System.out.println("Initializing SimpleDateFormat for - " + Thread.currentThread().getName() );
            return new SimpleDateFormat("dd/MM/yyyy");
        }
    };

    public static void main(String[] args) {
        ThreadLocalDemo td = new ThreadLocalDemo();
        // Two threads are created
        Thread t1 = new Thread(td, "Thread-1");
        Thread t2 = new Thread(td, "Thread-2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        System.out.println("Thread run execution started for " + Thread.currentThread().getName());
        System.out.println("Date formatter pattern is  " + dateFormat.get().toPattern());
        System.out.println("Formatted date is " + dateFormat.get().format(new Date()));
    }

}
