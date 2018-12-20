package com.tian.registry;

/**
 * @auther: lawt
 * @date: 2018/12/15 21
 * @Description:
 */
public class ZookeeperConfig {
    public static final String ZK_REGISTER_PATH = "/registrys";

    public static final String CONNECTION_STR = "127.0.0.1:2181";
    //集群zk的配置方式，也可以配置到我们的配置文件中
//    public static final String CONNECTION_STR = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183";
}
