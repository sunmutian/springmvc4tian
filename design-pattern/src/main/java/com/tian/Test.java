package com.tian;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lawt
 * @date 2018-08-28 10:59
 **/
public class Test {
    public synchronized  static void main(String[] args) {

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        String aa = "abcd";
        String str3 = new StringBuilder("ab").append("cd").toString();
        System.out.println(str3.intern() == str3);
    }
}
