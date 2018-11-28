package com.tian.jvm.reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用示例
 *
 * @author tianwc
 * @date 2018-11-21
 */
public class WeakReferenceMain {
    public static void main(String[] args) {
        WeakReference<String> sr = new WeakReference<>(new String("hello"));

        System.out.println(sr.get());
        //通知JVM的gc进行垃圾回收
        System.gc();
        System.out.println(sr.get());
    }
}
