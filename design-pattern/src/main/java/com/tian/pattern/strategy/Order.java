package com.tian.pattern.strategy;
/**
 * 订单信息
 *
 * @Author tianweichang
 * @Date 2018-08-10 10:54
 **/
public class Order {
    /**
     * 订单号
     */
    private String uid;
    /**
     * 用户号
     */
    private int userId;
    /**
     * 支付金额
     */
    private double amount;
    //这个参数，完全可以用Payment这个接口来代替
    //为什么？

    //完美地解决了switch的过程，不需要在代码逻辑中写switch了
    //更不需要写if    else if
    public PayState pay(PayType payType) {
        return payType.get().pay(this.uid, this.amount);
    }

    public Order() {
    }

    public Order(String uid, int userId, double amount) {
        this.uid = uid;
        this.userId = userId;
        this.amount = amount;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
