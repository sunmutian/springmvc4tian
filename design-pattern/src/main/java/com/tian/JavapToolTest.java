package com.tian;

/**
 * @auther: lawt
 * @date: 2018/11/2 11
 * @Description:
 */
public class JavapToolTest {
    int count=20;
    {
        count=12;
    }

    public JavapToolTest() {
        System.out.println(count);
    }

    public JavapToolTest(String namne) {
        System.out.println(namne);
    }
}
