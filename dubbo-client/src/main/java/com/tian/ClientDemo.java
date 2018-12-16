package com.tian;

import com.tian.proxy.RpcClientProxy;
import com.tian.registry.IServiceDiscovery;
import com.tian.registry.ServiceDiscoveryImpl;
import com.tian.service.IHelloService;

import java.io.IOException;

/**
 * Hello world!
 */
public class ClientDemo {
    public static void main(String[] args) {
        IServiceDiscovery registryCenter = new ServiceDiscoveryImpl();
        RpcClientProxy clientProxy = new RpcClientProxy(registryCenter);
        IHelloService helloService = clientProxy.create(IHelloService.class);
        System.out.println(helloService.sayHello("手写dubbo demo成功"));
    }
}
