package com.tian.concurrent;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量demo测试
 * 实例一：咱们公司男厕所只有三个坑，也就是同一时间是只能有三个人上大号，其他人能只能等待，任何时候上大号的人永远小于等于3人，
 * 实例二：假设咱们停车场只有10个车位。那么要是同时来了20个车，保安人员只能让10辆车进，其他排队等候。任何时候停车场所停车辆数永远小于等于10
 *
 * @author tianweichang
 * @date 2018-09-12 9:20
 **/
public class SemaphoreDemo {
    //三个蹲坑
    private Semaphore smp = new Semaphore(3);
    private Random rnd = new Random();

    class TaskDemo implements Runnable {
        private String id;

        TaskDemo(String id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                smp.acquire();
                System.out.println("Thread " + id + " 开始上厕所");
                Thread.sleep(rnd.nextInt(1000));//上厕所所花时间
                smp.release();
                System.out.println("Thread " + id + " 上完");
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
       /* SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        ExecutorService se = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            se.submit(semaphoreDemo.new TaskDemo("第" + i + "个人"));
        }
        se.shutdown();*/
    }
}
