package com.tian.pattern.adapter;

/**
 *测试
 * @author tianwc
 * @date 2018-11-21
 */
public class TestD {

    public static void main(String[] args) {

        //初始化一个德国插座对象， 用一个德标接口引用它
        DBSocketInterface dbSoket = new DBSocket();

        //创建一个旅馆对象
        Hotel hotel = new Hotel(dbSoket);

        //在旅馆中给手机充电
        hotel.charge();
    }
}