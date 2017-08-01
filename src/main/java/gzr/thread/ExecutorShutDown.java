package gzr.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 如果对象提供了shutdown，close等方法，一定要记得在用完后调用这些方法以释放资源，否则会出现资源泄露的情况，【尤其是线程池】
 * Created by gaozengrong on 16/11/22.
 */
public class ExecutorShutDown {
    public static void main(String[] args) throws InterruptedException {
        commonShutDownMethod();
        errorShutDownExample();
        recommendShutDownMethod();
    }

    /**
     * 普通的关闭线程池方法
     *
     * @throws InterruptedException
     */
    public static void commonShutDownMethod() throws InterruptedException {
        System.out.println("********************commonShutDownMethod********************");
        // 创建一个固定大小的线程池
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            System.out.println("创建线程" + i);
            Runnable run = () -> System.out.println("启动线程");
            // 在未来某个时间执行给定的命令
            service.execute(run);
        }
        // 关闭启动线程
        service.shutdown();
        // 等待子线程结束，再继续执行下面的代码
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("all thread complete");
    }

    /**
     * 错误的关闭线程池方法
     * 如果注释掉 if (Thread.currentThread().isInterrupted()) 这行 会输出"Still waiting..."
     *
     * @throws InterruptedException
     */
    public static void errorShutDownExample() throws InterruptedException {
        System.out.println("********************errorShutDownExample********************");
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit((Runnable)() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) { break; }
            }
        });

        executor.shutdownNow();
        if (!executor.awaitTermination(100, TimeUnit.MICROSECONDS)) {
            System.out.println("Still waiting...");
            System.exit(0);
        }
        System.out.println("Exiting normally...");
    }

    public static void recommendShutDownMethod() throws InterruptedException {
        System.out.println("********************recommendShutDownMethod********************");
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit((Runnable)() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) { break; }
            }
        });
        executor.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                executor.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not terminate");
                }
                System.out.println("Exiting normally...");
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            executor.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }
}
