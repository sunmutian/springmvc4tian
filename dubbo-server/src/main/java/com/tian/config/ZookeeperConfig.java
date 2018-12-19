package com.tian.config;

/**
 * @author tianweichang
 */
public class ZookeeperConfig {
    private String host;
    private int port;

    @Override
    public String toString() {
        return "ZookeeperConfig{" +
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
