package com.tian.pattern.template;

/**
 * 实现类 1
 *
 * @Author 小田哥
 * @Date 2018-11-10 15:17
 **/
public class Subclass1 extends AbstractTemplate {



    @Override
    protected void doSomeThing() {
        System.out.println("Subclass1 doSomeThing");
    }


    @Override
    protected void before() {
        System.out.println("Subclass1 before");
    }
}
