package com.tian.jvm.reference;

import java.lang.ref.SoftReference;
/**
 * 软引用示例
 *
 * @author tianwc
 * @date 2018-11-21
 */
public class SoftReferenceMain {
    public static void main(String[] args) {
        SoftReference<String> sr = new SoftReference<>(new String("hello"));
        System.out.println(sr.get());
        //通知JVM的gc进行垃圾回收
        System.gc();
        System.out.println(sr.get());
    }
}
