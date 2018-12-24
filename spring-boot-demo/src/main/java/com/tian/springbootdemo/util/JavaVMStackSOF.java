package com.tian.springbootdemo.util;

/**
 * VM Args: -Xss128k
 *
 * @author tianwc
 * @date 2018-12-12
 */
public class JavaVMStackSOF {
    private int count = 0;

    public static void main(String[] args) {
        new JavaVMStackSOF().method();
    }

    public void method() {
        System.out.println(++count);
        method();
    }
}