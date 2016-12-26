package gzr.sync;

/**
 * 用synchronized(Sync.class)实现了全局锁的效果
 * 【static synchronized方法，static方法可以直接类名加方法名调用，方法中无法使用this，所以它锁的不是this，而是类的Class对象，所以，static synchronized方法也相当于全局锁，相当于锁住了代码段。】
 * Created by gaozengrong on 16/12/26.
 */

class Sync2 {

    void test() {
        synchronized (Sync2.class){
            System.out.println("test开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }
    }
}

class MyThread2 extends Thread {
    public void run() {
        Sync2 sync = new Sync2();
        sync.test();
    }
}

class Main2 {

    public static void main(String[] args) {
        //三个线程使用不同Sync的对象
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread2();
            thread.start();
        }
    }
}
/*输出
test开始..
test结束..
test开始..
test结束..
test开始..
test结束..
 */