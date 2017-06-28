package gzr.thread;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable加入线程池运行，Runnable使用ExecutorService的execute方法，Callable使用submit方法
 * @author zengrong.gzr
 * @date 2017/03/25
 */
public class ExecuteCall {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results =new ArrayList<Future<String>>();
        for(int i=0;i<10;i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for(Future<String> fs : results){
            System.out.println(fs.get());
        }
    }
}
