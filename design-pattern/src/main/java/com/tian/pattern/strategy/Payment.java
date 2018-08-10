package com.tian.pattern.strategy;

/**
 * 支付渠道
 *
 * @Author tianweichang
 * @Date 2018-08-10 11:01
 **/
public interface Payment {

    PayState pay(String uid, double amount);

}