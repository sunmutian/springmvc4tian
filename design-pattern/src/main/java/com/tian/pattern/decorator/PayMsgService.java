package com.tian.pattern.decorator;

/**
 * 抽象装饰角色
 * 增加一个发站内信的功能接口类
 *
 * @author tianwc
 * @date 2018/11/20
 */
public abstract class PayMsgService implements PayService {

    /**
     * 发站内信
     */
    public abstract void sendMsg();

    /**
     * 发邮件
     */
    public abstract void sendMail();
}
