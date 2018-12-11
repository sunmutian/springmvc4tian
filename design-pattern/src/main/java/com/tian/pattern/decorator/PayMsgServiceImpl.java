package com.tian.pattern.decorator;

/**
 * 装饰角色
 *
 * @author tianwc
 * @date 2018/11/20
 */
public class PayMsgServiceImpl extends PayMsgService {

    private PayService payService;


    public PayMsgServiceImpl(PayService payService) {
        this.payService = payService;
    }

    /**
     * 发送站内信
     */
    @Override
    public void sendMsg() {
        System.out.println("send message");
    }

    /**
     * 支付
     */
    @Override
    public void pay() {
        System.out.println("pay start");
        this.payService.pay();
        this.sendMsg();
        this.sendMail();
        System.out.println("pay end");
    }

    /**
     * 发邮件
     */
    @Override
    public void sendMail() {
        System.out.println("send mail");
    }
}
