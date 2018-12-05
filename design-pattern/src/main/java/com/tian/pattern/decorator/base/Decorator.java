package com.tian.pattern.decorator.base;
/**
 * 抽象装饰类
 *
 * @author 小田哥
 * @date 2018/12/5
 */
public abstract class Decorator implements Component {
    public Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void doSomeThing() {
        this.component.doSomeThing();
    }
}
