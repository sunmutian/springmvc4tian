package com.tian.netty.memory;

/**
 * 类的初始化顺序
 * (无显示继承)
 *
 * @author lawt
 * @date 2019年1月16日
 */
public class InitialOrderTest {
    /**
     * 静态变量
     */
    private static String STATIC_FIELD = "静态变量";
    /**
     * 变量
     */
    private String field = "变量";

    // 静态初始化块
    static {
        System.out.println(STATIC_FIELD);
        System.out.println("静态初始化块");
    }

    // 初始化块
    {
        System.out.println("***********************************");
        System.out.println(field);
        System.out.println("初始化块");
    }

    /**
     * 构造器
     */
    public InitialOrderTest() {
        System.out.println("构造器");
    }

    public static void main(String[] args) {
        new InitialOrderTest();
        System.out.println("--------------------------------------");
        new InitialOrderTest();
    }
}
