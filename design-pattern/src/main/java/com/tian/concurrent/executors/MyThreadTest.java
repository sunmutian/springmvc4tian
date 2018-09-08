package com.tian.concurrent.executors;

import java.util.concurrent.*;

/**
 * @author tianweichang
 * @date 2018-08-27 10:07
 **/
public class MyThreadTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
        executorService.execute(t4);
        executorService.execute(t5);

        schedual();
        new ThreadPoolExecutor(
                2, 3, 30, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                new MyThreadFactory("myPool"),
                new ThreadPoolExecutor.CallerRunsPolicy());

        new ThreadPoolExecutor(
                2, 4, 30, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2),
                new MyThreadFactory("CookieRecorderPool"),
                new ThreadPoolExecutor.CallerRunsPolicy());

    }

    /**
     *
     */
    static void schedual() {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("================");
            }
        }, 1000, 6000, TimeUnit.MILLISECONDS);
        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间打印系统时间，证明两者是互不影响的
            @Override
            public void run() {
                System.out.println(System.nanoTime());
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }
}
