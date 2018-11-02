package com.tian.pattern.facade;

/**
 * @auther: lawt
 * @date: 2018/10/29 22
 * @Description: 客户B要买红茶
 */
public class CustomerB {
    public static void main(String[] args) {
        SaleMen saleMen=new SaleMen();
        saleMen.saleRedTea();
    }
}
