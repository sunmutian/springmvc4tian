package com.tian.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tianweichang
 * @date 2018-09-03 16:12
 **/
public class ThreadLocalTest {
    /**
     * 三个ThreadLocal
     */
    private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal3 = new ThreadLocal<>();

    public static void main(String[] args) {
        //线程池变量指定一个线程
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                threadLocal1.set("123");
                threadLocal2.set("234");
                threadLocal3.set("345");
            });
        }
    }
}
