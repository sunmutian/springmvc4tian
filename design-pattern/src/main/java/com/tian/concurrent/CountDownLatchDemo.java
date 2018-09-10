package com.tian.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author lawt
 * @date 2018-09-10 9:18
 * CountDownLatch使用案例
 * 模拟开会场景，当所有人到场后就开始开会
 **/
public class CountDownLatchDemo {
    /**
     * 参会人员必须要20个
     */
    private static final int THREAD_TOTAL_NUM = 20;
    /**
     * 计数器
     */
    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(THREAD_TOTAL_NUM);

    public static void main(String[] args) throws InterruptedException {

      /*  for (int i = 0; i < THREAD_TOTAL_NUM; i++) {
            int index = i + 1;
            new Thread(() -> {
                try {
                    System.out.println("第" + index + "个人到场");
                    //这个人到会花的时间
                    Thread.sleep(new Random().nextInt(3000));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //第index人员到场
                COUNT_DOWN_LATCH.countDown();

            }).start();
        }
        //检查是否全部人员都到场
        COUNT_DOWN_LATCH.await();
        System.out.println("人员都已经到场，可以开会了");*/
        noCountDownLatch();
    }

    /**
     * 没有CountDownLatch的版本
     */
    private static void noCountDownLatch() {
        for (int i = 1; i <= THREAD_TOTAL_NUM; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println("第" + index + "个人到场！");
                    //模拟收集第i个龙珠,随机模拟不同的寻找时间
                    Thread.sleep(new Random().nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("全部人已经单场，开始开会");
    }
}
