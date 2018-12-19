package com.tian;

import com.tian.config.ZookeeperConfig;
import com.tian.main.DubboServerMain;
import com.tian.registry.IRegistryCenter;
import com.tian.registry.RegistryCenterImpl;
import com.tian.rpc.RpcServer;
import com.tian.service.HelloServiceImpl;
import com.tian.service.IHelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 测试
 */
public class ServerDemo {
    public static void main(String[] args) {
        DubboServerMain.main();
    }
}
