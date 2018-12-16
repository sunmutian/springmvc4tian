package com.tian;

import com.tian.registry.IRegistryCenter;
import com.tian.registry.RegistryCenterImpl;
import com.tian.rpc.RpcServer;
import com.tian.service.HelloServiceImpl;
import com.tian.service.IHelloService;

import java.io.IOException;

/**
 * 测试
 */
public class ServerDemo {
    public static void main(String[] args) {
        //根据你的服务名称  实例化对应的
        IHelloService iGpHello = new HelloServiceImpl();
        IRegistryCenter registerCenter = new RegistryCenterImpl();
        //服务发布,监听端口--->类中
        RpcServer rpcServer=new RpcServer(registerCenter,"127.0.0.1:8080");
        //服务端需要考虑的事情是：服务名称  绑定   对应多少个实例对象     2 3  4
        //服务名称和实例对象的关系
        rpcServer.bind(iGpHello);
        rpcServer.publisher();
    }
}
