package com.tian.test;

import com.tian.config.ServerAddresses;
import com.tian.config.Service;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringSchema {

    @SuppressWarnings("resource")
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:xml/application.xml");
        ServerAddresses zookeeper = (ServerAddresses) ctx.getBean("zookeeperConfig");
        System.out.println(zookeeper);
        Service service = (Service) ctx.getBean("service1");
        System.out.println(service);
    }
}
