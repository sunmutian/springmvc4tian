package com.tian.pattern.facade;

/**
 * @auther: lawt
 * @date: 2018/10/29 22
 * @Description: 客户A要买绿茶
 */
public class CustomerA {
    public static void main(String[] args) {
        SaleMen saleMen=new SaleMen();
        saleMen.saleGreenTea();
    }
}
