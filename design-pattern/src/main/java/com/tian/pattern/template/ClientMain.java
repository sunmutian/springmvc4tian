package com.tian.pattern.template;
/**
 * 客户端
 *
 * @Author 小田哥
 * @Date 2018-11-10 15:17
 **/
public class ClientMain {
    public static void main(String[] args) {
        AbstractTemplate subclass1 = new Subclass1();
        subclass1.templateMethod();
        System.out.println("---------------------");
        AbstractTemplate subclass2 = new Subclass2();
        subclass2.templateMethod();
    }
}
