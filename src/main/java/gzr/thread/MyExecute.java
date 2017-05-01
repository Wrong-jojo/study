package gzr.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author zengrong.gzr
 * @date 2017/04/18
 */
public class MyExecute {
    public static void main(String[] args) {
        List<Callable<String>> callables = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println(new Date());
        list.forEach(i -> {
            callables.add(() -> {
                if ("10".equals(i)) {
                    throw new Exception("123");
                }
                return i;
            });
        });

        long startTime = System.currentTimeMillis();
        List<Future<String>> futures = MyThreadExecutors.getInstance().invokeAll(callables, 5000);
        long endTime = System.currentTimeMillis();
        System.out.println("多线程运行时间：" + (endTime - startTime) + "ms");

        List<String> results = new ArrayList<>();
        futures.forEach(future -> {
            try {
                String i = future.get();
                results.add(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(results);
    }
}
