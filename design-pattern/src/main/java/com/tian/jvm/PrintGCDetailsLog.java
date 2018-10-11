package com.tian.jvm;

public class PrintGCDetailsLog {
    private static final int int_1MB = 1024 * 1024;

    public static void main(String[] args) {
        testAllocation();
    }

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * int_1MB];
        allocation2 = new byte[2 * int_1MB];
        allocation3 = new byte[2 * int_1MB];
        allocation4 = new byte[2 * int_1MB];
    }
}
