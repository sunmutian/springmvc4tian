package com.tian.springbootdemo.util;

/**
 * VM Args: -Xss128k
 *
 * @author tianwc
 * @date 2018-12-12
 */
public class JavaVMStackOOM {
    public static void main(String[] args) {
        int count = 0;
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(5000);
                        } catch (Exception e) {
                        }
                    }
                }
            });
            thread.start();
            System.out.println(++count);
        }
    }
}