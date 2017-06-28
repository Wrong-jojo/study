package gzr.thread;

import java.util.concurrent.Callable;

/**
 * @author zengrong.gzr
 * @date 2017/03/25
 */
public class TaskWithResult implements Callable {
    private int id;
    private static int count =10;
    private final int time =count--;
    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("execute method call().");
        return "Result of TaskWithResult : "+ id+", Time= "+time;
    }
}
