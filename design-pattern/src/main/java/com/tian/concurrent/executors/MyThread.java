package com.tian.concurrent.executors;

/**
 * @author tianweichang
 * @date 2018-08-27 9:59
 **/
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("" + Thread.currentThread().getName() + "执行ing");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("" + Thread.currentThread().getName() + "执行over");
    }
}
