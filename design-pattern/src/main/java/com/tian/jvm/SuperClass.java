package com.tian.jvm;

public class SuperClass {
    static {
        System.out.println("父类静态模块");
    }

    public static final String value = "hello world";
}
