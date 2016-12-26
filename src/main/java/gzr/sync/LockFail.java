package gzr.sync;

/**
 * Created by gaozengrong on 16/12/26.
 */

class Sync1 {

    synchronized void test() {
        System.out.println("test开始..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test结束..");
    }
}

class MyThread1 extends Thread {

    public void run() {
        Sync1 sync = new Sync1();
        sync.test();
    }
}

class Main1 {

    public static void main(String[] args) {
        //三个线程使用不同Sync的对象
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread1();
            thread.start();
        }
    }
}
/*输出
test开始..
test开始..
test开始..
test结束..
test结束..
test结束..
 */
