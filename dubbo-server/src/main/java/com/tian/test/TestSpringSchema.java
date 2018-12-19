package com.tian.test;

import com.tian.config.Service;
import com.tian.config.ZookeeperConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringSchema {

    @SuppressWarnings("resource")
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:xml/application.xml");

        Service service1 = (Service) ctx.getBean("service1");
        Service service2 = (Service) ctx.getBean("st");

        System.out.println("name: " + service1.getName() + " age :" + service1.getAge());
        System.out.println("name: " + service2.getName() + " age :" + service2.getAge());

        ZookeeperConfig zookeeper = (ZookeeperConfig) ctx.getBean("zookeeper");
        System.out.println(zookeeper);
    }
}
