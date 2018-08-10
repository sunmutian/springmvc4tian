package com.tian.pattern.strategy;

/**
 * 支付完成后的状态
 *
 * @Author tianweichang
 * @Date 2018-08-10 10:56
 **/
public class PayState {
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回数据
     */
    private Object data;
    /**
     * 返回提示
     */
    private String msg;

    public PayState(int code, String msg, Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return ("支付状态：[" + code + "]," + msg + ",交易详情：" + data);
    }
}
