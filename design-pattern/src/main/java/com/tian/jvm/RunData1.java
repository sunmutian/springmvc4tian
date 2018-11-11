package com.tian.jvm;

/**
 * @auther: tianweichang
 * @date: 2018/11/11 13
 * @Description:
 */
//运行时, jvm 把RunData1的信息都放入方法区 
public class RunData1 {
    //new RunData1实例后， name 引用放入栈区里， 对象放入堆里
    private String name;

    public RunData1(String name) {
        this.name = name;
    }

    //print方法本身放入 方法区里。
    public void test() {
        System.out.println(this.name);
    }
}
