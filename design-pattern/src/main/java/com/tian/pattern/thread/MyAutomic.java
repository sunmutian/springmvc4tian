package com.tian.pattern.thread;

/**
 * 模拟volatile不能保证原子性 i++等情况
 *
 * @Author tianweichang
 * @Date 2018-08-13 16:34
 **/
public class MyAutomic {
    private static volatile int count = 0;

    private static void increase() {
        count++;
    }

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[30];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k = 0; k < 10000; k++) {
                        increase();
                        System.out.println(count);
                    }
                }
            });
            threads[i].start();
            Thread.sleep(1);
        }
    }
}
