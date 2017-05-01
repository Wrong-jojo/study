package gzr.thread;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import com.google.common.collect.Lists;

/**
 * @author zengrong.gzr
 * @date 2017/04/18
 */
public class MyThreadExecutors {
    private static ReentrantLock lock = new ReentrantLock();

    private ThreadPoolExecutor threadPoolExecutor;

    private static MyThreadExecutors threadExecutors;

    //默认超时两百毫秒
    private static final long DEFAULT_TIME_OUT = 200;

    public static MyThreadExecutors getInstance() {
        if (threadExecutors == null) {
            lock.lock();
            try {
                if (threadExecutors == null) {
                    threadExecutors = new MyThreadExecutors();
                }
            } finally {
                lock.unlock();
            }
        }
        return threadExecutors;
    }

    //超过timeout时间的任务会被干掉
    private MyThreadExecutors() {
        threadPoolExecutor = new ThreadPoolExecutor(10, 100, 100000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1000), new ThreadPoolExecutor.DiscardPolicy());
    }

    public <T> Future<T> submit(Callable<T> t) {
        return threadPoolExecutor.submit(t);
    }

    public <T> List<Future<T>> invokeAll(List<Callable<T>> tasks, long timeOutMills) {
        try {
            if (timeOutMills <= 0) {
                timeOutMills = DEFAULT_TIME_OUT;
            }
            return threadPoolExecutor.invokeAll(tasks, timeOutMills, TimeUnit.MILLISECONDS);
        } catch (Throwable t) {
            return Lists.newArrayList();
        }
    }

}
