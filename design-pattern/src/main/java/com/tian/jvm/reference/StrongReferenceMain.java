package com.tian.jvm.reference;

/**
 * 强引用示例
 *
 * @author tianwc
 * @date 2018-11-21
 */
public class StrongReferenceMain {
    public static void main(String[] args) {
        StrongReferenceMain strongReferenceMain = new StrongReferenceMain();
        strongReferenceMain.test();
    }

    public void test() {
        Object object = new Object();
        String str = "hello";
        Object[] objArr = new Object[1000];
    }
}
