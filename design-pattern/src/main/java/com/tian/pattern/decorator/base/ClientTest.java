package com.tian.pattern.decorator.base;

/**
 * 客户端
 *
 * @author 小田哥
 * @date 2018/12/5
 */
public class ClientTest {
    public static void main(String[] args) {
        Component component = new ConcreteDecorator(new ConcretComponent());
        component.doSomeThing();
    }
}
