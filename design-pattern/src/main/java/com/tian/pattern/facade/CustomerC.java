package com.tian.pattern.facade;

/**
 * @auther: lawt
 * @date: 2018/10/29 22
 * @Description: 客户C要买奶茶
 */
public class CustomerC {
    public static void main(String[] args) {
        SaleMen saleMen = new SaleMen();
        saleMen.saleMilkTea();
    }
}
