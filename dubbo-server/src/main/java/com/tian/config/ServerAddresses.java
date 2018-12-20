package com.tian.config;

/**
 * 服务地址和端口
 *
 * @author lawt
 */
public class ServerAddresses {
    private String host;
    private int port;

    @Override
    public String toString() {
        return "ServerAddresses{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
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
