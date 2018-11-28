package com.tian.pattern.adapter;

/**
 * 测试
 * @author tianwc
 * @date 2018-11-21
 */
public class TestAdapter {
    public static void main(String[] args) {

        GBSocketInterface gbSocket = new GBSocket();

        Hotel hotel = new Hotel();

        SocketAdapter socketAdapter = new SocketAdapter(gbSocket);

        hotel.setSocket(socketAdapter);

        hotel.charge();
    }
}
