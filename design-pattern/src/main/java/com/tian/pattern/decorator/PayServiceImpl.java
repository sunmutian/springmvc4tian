package com.tian.pattern.decorator;

/**
 * 具体构建角色
 *
 * @author tianwc
 * @date 2018/11/20
 */
public class PayServiceImpl implements PayService {
    @Override
    public void pay() {
        System.out.println("执行PayServiceImpl--的--支付--支付方法");
    }
}
