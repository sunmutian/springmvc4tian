package com.tian.bean;


import com.tian.config.Service;
import com.tian.config.ZookeeperConfig;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class DubboNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("config", new DubboBeanDefinitionParser(ZookeeperConfig.class));
        registerBeanDefinitionParser("service", new DubboBeanDefinitionParser(Service.class));
    }
}
