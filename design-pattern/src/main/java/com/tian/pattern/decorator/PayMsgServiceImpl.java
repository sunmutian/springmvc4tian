package com.tian.pattern.decorator;

/**
 * 装饰角色 增加了sendMsg
 *
 * @author tianwc
 * @date 2018/11/20
 */
public class PayMsgServiceImpl implements PayMsgService {

    private PayService payService;

    public PayMsgServiceImpl(PayService payService) {
        this.payService = payService;
    }

    /**
     * 交易
     */
    @Override
    public void pay() {
        System.out.println("开始交易");
        payService.pay();
        sendMsg();
        System.out.println("交易完成");
    }

    /**
     * 发送站内信
     */
    @Override
    public void sendMsg() {
        System.out.println("发送站内信");
    }
}
