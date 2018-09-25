package com.tian.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tianweichang
 * @date 2018-09-14 15:21
 **/
public class Test {
    public static void main(String[] args) {
//        ReferenceCountGC.testGC();
        AtomicInteger integer = new AtomicInteger();

        int r1 = integer.addAndGet(100);
        System.out.println(r1);
        int r2 = integer.addAndGet(9);
        System.out.println(r2);
    }
}
