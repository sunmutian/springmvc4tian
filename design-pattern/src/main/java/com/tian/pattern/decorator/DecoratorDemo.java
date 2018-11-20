package com.tian.pattern.decorator;

/**
 * 装饰模式demo测试类
 *
 * @author tianwc
 * @date 2018/11/20
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        PayService payService = new PayServiceImpl();
        PayService payService2 = new PayMsgServiceImpl(payService);
        payService2.pay();
    }
}
