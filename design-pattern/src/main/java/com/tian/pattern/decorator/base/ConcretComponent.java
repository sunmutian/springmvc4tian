package com.tian.pattern.decorator.base;
/**
 * 具体构件
 *
 * @author 小田哥
 * @date 2018/12/5
 */
public class ConcretComponent implements Component {
    @Override
    public void doSomeThing() {
        System.out.println("ConcretComponent do");
    }
}
