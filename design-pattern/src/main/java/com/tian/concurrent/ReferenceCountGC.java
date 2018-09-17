package com.tian.concurrent;

/**
 * 引用计数器缺陷demo实现
 *
 * @author tianweichang
 * @date 2018-09-14 15:14
 **/
public class ReferenceCountGC {
    public Object instance = null;
    private static final int _1MB = 1024;
    /**
     * 这个成员属性的唯一意义就是占内存，以便在GCV日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String [] args) {
        ReferenceCountGC obgA = new ReferenceCountGC();
        ReferenceCountGC objB = new ReferenceCountGC();
        obgA.instance = objB;
        objB.instance = obgA;

        obgA = null;
        objB = null;

        System.gc();

    }
}
