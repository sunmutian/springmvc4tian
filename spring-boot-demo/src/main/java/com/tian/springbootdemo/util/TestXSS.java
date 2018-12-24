package com.tian.springbootdemo.util;

public class TestXSS {

    private static long count = 0;

    public static void main(String[] args) {
        infinitelyRecursiveMethod(1);

    }

    public static void infinitelyRecursiveMethod(long a) {
        System.out.println(count++);
        infinitelyRecursiveMethod(a);
    }

    private int i = 0;

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

}
