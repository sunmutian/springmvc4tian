package com.tian.sk.bean;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BigDecimal feeAmount=null;
        if(feeAmount.compareTo(new BigDecimal("0"))!=0){
            System.out.println("aaa");
        }else {
            System.out.println("11111");
        }
    }
}
