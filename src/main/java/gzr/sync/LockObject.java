package gzr.sync;

/**
 * 用synchronized (this)锁住同一个对象
 * Created by gaozengrong on 16/12/26.
 */

class Sync3 {

    void test() {
        synchronized (this) {
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

class MyThread3 extends Thread {

    private Sync3 sync;

    MyThread3(Sync3 sync){
        this.sync = sync;
    }

    public void run() {
        sync.test();
    }
}

class Main3 {

    public static void main(String[] args) {
        //让三个线程使用同一个Sync的对象
        Sync3 sync = new Sync3();
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread3(sync);
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