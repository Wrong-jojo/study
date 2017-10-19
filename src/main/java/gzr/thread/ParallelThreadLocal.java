package gzr.thread;

import java.util.stream.IntStream;

/**
 * @author zengrong.gzr
 * @date 2017/10/18
 */
public class ParallelThreadLocal {
    public static void main(String[] args) {
        ThreadContext.set("MAIN");
        System.out.printf("Main Thread: %s\n", ThreadContext.get());

        IntStream.range(0, 8).boxed().parallel().forEach(n -> {
            System.out.printf("Parallel Consumer - %d: %s\n", n, ThreadContext.get());
        });
    }

    private static class ThreadContext {
        //private static ThreadLocal<String> val = ThreadLocal.withInitial(() -> "empty");
        private static InheritableThreadLocal<String> val = new InheritableThreadLocal<>();

        public ThreadContext() {
        }

        public static String get() {
            return val.get();
        }

        public static void set(String x) {
            ThreadContext.val.set(x);
        }
    }
}
/*
使用ThreadLocal输出
Main Thread: MAIN
Parallel Consumer - 7: empty
Parallel Consumer - 1: empty
Parallel Consumer - 0: empty
Parallel Consumer - 5: MAIN
Parallel Consumer - 6: empty
Parallel Consumer - 2: empty
Parallel Consumer - 3: MAIN
Parallel Consumer - 4: empty

使用InheritableThreadLocal输出[创建一个线程时如果保存了所有 InheritableThreadLocal 对象的值，那么这些值也将自动传递给子线程]
Parallel Consumer - 7: MAIN
Parallel Consumer - 5: MAIN
Parallel Consumer - 2: MAIN
Parallel Consumer - 6: MAIN
Parallel Consumer - 3: MAIN
Parallel Consumer - 4: MAIN
Parallel Consumer - 1: MAIN
Parallel Consumer - 0: MAIN
 */
