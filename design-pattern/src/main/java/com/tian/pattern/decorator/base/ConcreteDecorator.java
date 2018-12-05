package com.tian.pattern.decorator.base;
/**
 * 具体装饰类
 *
 * @author 小田哥
 * @date 2018/12/5
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void doSomeThing() {
        System.out.println("ConcreteDecorator do");
        super.doSomeThing();
    }
}
