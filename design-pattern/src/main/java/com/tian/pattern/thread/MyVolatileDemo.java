package com.tian.pattern.thread;

/**
 * 模拟线程volatile的内存可见性
 * @Author tianweichang
 * @Date 2018-08-13 16:02
 **/
public class MyVolatileDemo implements Runnable {
    volatile boolean quit = false;
    int i = 0;

    @Override
    public void run() {
        long s = System.currentTimeMillis();
        while (!quit) {
            i++;
        }
        System.out.println("线程退出" + (System.currentTimeMillis() - s));
    }
   /* public static void main(String[] args) throws InterruptedException {
        MyVolatileDemo accounting = new MyVolatileDemo();
        Thread a1 = new Thread(accounting, "a");
        Thread a2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("开始通知线程结束");
                    //修改quit变量的值
                    accounting.setQuit(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "b");
        a2.start();
        a1.start();
        Thread.sleep(1000);
    }
    public void setQuit(boolean quit) {
        this.quit = quit;
    }*/
}
