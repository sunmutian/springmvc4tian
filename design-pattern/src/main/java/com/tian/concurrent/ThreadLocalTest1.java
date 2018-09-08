package com.tian.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tianweichang
 * @date 2018-09-03 16:23
 **/
public class ThreadLocalTest1 {
    private static final int THREAD_LOOP_SIZE = 1;
    private static final int MOCK_DIB_DATA_LOOP_SIZE = 1000;
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);

        for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
            for (int j = 0; j < MOCK_DIB_DATA_LOOP_SIZE; j++) {
                executorService.execute(() -> threadLocal.set(("123" + MOCK_DIB_DATA_LOOP_SIZE).toString()));
            }
        }
    }
}
