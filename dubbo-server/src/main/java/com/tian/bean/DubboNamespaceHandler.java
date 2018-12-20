package com.tian.bean;


import com.tian.config.Service;
import com.tian.config.ServerAddresses;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class DubboNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("config", new DubboBeanDefinitionParser(ServerAddresses.class));
        registerBeanDefinitionParser("service", new DubboBeanDefinitionParser(Service.class));
    }
}
