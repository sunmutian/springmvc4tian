package com.tian.registry;

/**
 * @auther: lawt
 * @date: 2018/12/15 21
 * @Description: 注册接口
 */
public interface IRegistryCenter {
    /**
     * serviceName:com.tian.api.IHelloService
     * serviceAddress:127.0.0.1:8080
     * 将serviceName与serviceAddress绑定在一起并主持到zookeeper上去
     *
     * @param serviceName    service 名称
     * @param serviceAddress 服务地址
     */
    void register(String serviceName, String serviceAddress);
}
