package com.tian.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal内存溢出
 *
 * @author tianweichang
 * @date 2018-09-18 13:48
 **/
public class ThreadLocalOOMDemo {
    private static final int THREAD_LOOP_SIZE = 500;
    private static final int MOCK_BIG_DATA_LOOP_SIZE = 10000;
    private static ThreadLocal<List<User>> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //定义一个指定大小的线程池，大小为THREAD_LOOP_SIZE
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);
        for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    threadLocal.set(new ThreadLocalOOMDemo().addBigList());
                    Thread t = Thread.currentThread();
                    System.out.println(Thread.currentThread().getName());
                    //threadLocal.remove(); //不取消注释的话就可能出现OOM
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    private List<User> addBigList() {
        List<User> params = new ArrayList<>(MOCK_BIG_DATA_LOOP_SIZE);
        for (int i = 0; i < MOCK_BIG_DATA_LOOP_SIZE; i++) {
            params.add(new User("zhangsan", "password" + i, "男", i));
        }
        return params;
    }

}
