package gzr.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zengrong.gzr
 * @Date 2017/03/01
 */
public class FlowLimitUtils {
    private static final ConcurrentMap<String, RateLimiter> RATE_LIMITER_MAP = new ConcurrentHashMap<String, RateLimiter>();

    public static void createFlowLimitMap(String resource, double qps) {
        RateLimiter limiter = RATE_LIMITER_MAP.get(resource);
        if (limiter == null) {
            limiter =RateLimiter.create(qps);
            RATE_LIMITER_MAP.putIfAbsent(resource, limiter);
        }
        limiter.setRate(qps);
    }


    public static boolean enter(String resource) throws Exception {
        RateLimiter limiter = RATE_LIMITER_MAP.get(resource);
        if (limiter == null) {
            throw new Exception(resource);
        }
        //tryAcquire():从RateLimiter获取许可，如果该许可可以在无延迟下的情况下立即获取得到的话
        if (!limiter.tryAcquire()) {
            System.out.println(">>>>>>>>>>>>>>>>>哎呀，被限流了>>>>>>>>");
            return true;
        }
        return false;
    }



    static class RequestWork implements Runnable{
        @Override
        public void run() {
            try {
                if(!enter("limit")){
                    System.out.println("++++++++++++哈哈哈，没有被限流");
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        String source= "limit";
        double qps= 10;
        createFlowLimitMap(source, qps);
        Thread.sleep(1000L);
        ExecutorService pools= Executors.newFixedThreadPool(20);
        for(int i=0;i<20;i++){
            RequestWork requestWork = new RequestWork();
            pools.execute(requestWork);
        }
    }
}
