package com.tian.pattern.decorator;

/**
 * 装饰角色
 *
 * @author tianwc
 * @date 2018/11/20
 */
public interface PayMsgService extends PayService {
    /**
     * 支付
     */
    @Override
    void pay();

    /**
     * 发站内信
     */
    void sendMsg();
}
