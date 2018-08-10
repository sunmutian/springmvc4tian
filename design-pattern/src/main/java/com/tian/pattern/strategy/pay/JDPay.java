package com.tian.pattern.strategy.pay;

import com.tian.pattern.strategy.PayState;
import com.tian.pattern.strategy.Payment;

/**
 *
 * @Author tianweichang
 * @Date 2018-08-10 11:00
 **/
public class JDPay implements Payment {

    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("欢迎使用京东");
        System.out.println("查询账户余额，开始扣款");
        return new PayState(200,"支付成功",amount);
    }
}