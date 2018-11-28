package com.tian.pattern.adapter;

/**
 * 德国插座
 */
public class DBSocket implements DBSocketInterface {
    @Override
    public void powerWithTwoRound() {
        System.out.println("使用两项圆头的插孔供电");
    }
}
