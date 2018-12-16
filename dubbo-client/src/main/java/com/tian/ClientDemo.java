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
        System.out.println("客户端发起远程调用");
        IHelloService helloService = clientProxy.create(IHelloService.class);
        if (helloService == null) {
            System.out.println("未找到服务，动态代理失败");
            return;
        }
        System.out.println(helloService.sayHello("调用成功"));
    }
}
