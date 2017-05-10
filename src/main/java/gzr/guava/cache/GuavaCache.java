package gzr.guava.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.SneakyThrows;

/**
 * Guava Cache是一个全内存的本地缓存实现，它提供了线程安全的实现机制。整体上来说Guava cache 是本地缓存的不二之选，简单易用，性能好
 * 有两种创建方式：1. cacheLoader　2. callable callback
 * 通过这两种方法创建的cache，和通常用map来缓存的做法比，不同在于，这两种方法都实现了一种逻辑——从缓存中取key X的值，如果该值已经缓存过了，则返回缓存中的值，如果没有缓存过，可以通过某个方法来获取这个值。
 * 但不同的在于cacheloader的定义比较宽泛，是针对整个cache定义的，可以认为是统一的根据key值load value的方法。而callable的方式较为灵活，允许你在get的时候指定。
 *
 * @author zengrong.gzr
 * @date 2017/05/10
 */
public class GuavaCache {

    //@SneakyThrows不在方法定义中声明所检查的异常，而将其扔掉
    @SneakyThrows
    public static void main(String[] args) {
        runLoadingCache();
        System.out.println("*************************************");
        runCallableCache();
    }

    private static void runLoadingCache() throws ExecutionException {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(20 * 1000, TimeUnit.MILLISECONDS).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return "hello " + key + "!";
            }
        });
        System.out.println("jerry value:" + cache.apply("jerry"));
        System.out.println("jerry value:" + cache.get("jerry"));
        System.out.println("peida value:" + cache.get("peida"));
        System.out.println("peida value:" + cache.apply("peida"));
        System.out.println("lisa value:" + cache.apply("lisa"));
        cache.put("harry", "ssdded");
        System.out.println("harry value:" + cache.get("harry"));
    }

    /**
     * CallableCache比较灵活，允许在get的时候指定值
     * @throws ExecutionException
     */
    private static void runCallableCache() throws ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(20 * 100, TimeUnit.MILLISECONDS).build();
        String resultVal = cache.get("jerry", () -> "hello " + "jerry" + "!");
        System.out.println("jerry value : " + resultVal);
        resultVal = cache.get("peida", () -> "hello " + "peida" + "!");
        System.out.println("peida value : " + resultVal);
    }
}
