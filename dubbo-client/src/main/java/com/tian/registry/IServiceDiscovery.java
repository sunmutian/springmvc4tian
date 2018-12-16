package com.tian.registry;

/**
 * @auther: tianweichang
 * @date: 2018/12/15 21
 * @Description:
 */
public interface IServiceDiscovery {
    //serviceName:com.tian.api.IHelloService
    //serviceAddress:127.0.0.1:8080
    //将serviceName与serviceAddress绑定在一起并主持到zookeeper上去
    String discover(String serviceName);
}
