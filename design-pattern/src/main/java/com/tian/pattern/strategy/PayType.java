package com.tian.pattern.strategy;

import com.tian.pattern.strategy.pay.AliPay;
import com.tian.pattern.strategy.pay.JDPay;
import com.tian.pattern.strategy.pay.UnionPay;
import com.tian.pattern.strategy.pay.WechatPay;

/**
 * Copyright © 2018 上海金互行金融服务有限公司. All rights reserved. *
 * <p>
 * 支付方式 TODO
 *
 * @Author tianweichang
 * @Date 2018-08-10 11:00
 **/
public enum PayType {
    ALI_PAY(new AliPay()),
    WECHAT_PAY(new WechatPay()),
    UNION_PAY(new UnionPay()),
    JD_PAY(new JDPay());

    private Payment payment;
    PayType(Payment payment){
        this.payment = payment;
    }

    public Payment get(){ return  this.payment;}
}
