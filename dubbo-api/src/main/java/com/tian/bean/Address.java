package com.tian.bean;

import java.io.Serializable;

/**
 * @auther: lawt
 * @date: 2018/12/16 20
 * @Description: 地址信息
 */
public class Address implements Serializable {
    /**
     * ip
     */
    private String host;
    /**
     * 端口
     */
    private int port;

    public Address(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
