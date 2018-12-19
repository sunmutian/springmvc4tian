package com.tian.test;

import com.tian.config.ZookeeperConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringSchema {

    @SuppressWarnings("resource")
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:xml/application.xml");
        ZookeeperConfig zookeeper = (ZookeeperConfig) ctx.getBean("zookeeperConfig");
        System.out.println(zookeeper);
    }
}
