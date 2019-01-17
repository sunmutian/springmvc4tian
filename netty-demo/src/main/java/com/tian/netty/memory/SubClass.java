package com.tian.netty.memory;

/**
 * 类的初始化顺序
 *
 * @author lawt
 * @date 2019年1月16日
 */
public class SubClass extends Parent {

    // 静态变量
    public static String s_StaticField = "子类--静态变量";

    // 变量
    public String s_Field = "子类--变量";

    public int i = 0;

    // 静态初始化块
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态初始化块");
    }

    // 初始化块
    {
        System.out.println(s_Field);
        System.out.println("子类--初始化块");
    }

    // 构造器
    public SubClass() {
        System.out.println("子类--构造器");
        System.out.println("i=" + i + ",j=" + j);
    }

    @Override
    public void test() {
        System.out.println("子类---test");
        System.out.println("子类---i=" + i);
    }

    // 程序入口
    public static void main(String[] args) {
        Parent parent = new SubClass();
        System.out.println("**Parent parent = new SubClass()**" + parent.i);
        System.out.println("**Parent parent = new SubClass()**" + parent.i);
        parent.test();

        System.out.println("-----------------------------------");

        SubClass subClass = new SubClass();
        System.out.println("=======" + subClass.i);
        subClass.test();
        System.out.println("***********************************");

        Parent p = new Parent();
        System.out.println("**  Parent p = new Parent()**i=" + p.i);
        p.test();
    }
}