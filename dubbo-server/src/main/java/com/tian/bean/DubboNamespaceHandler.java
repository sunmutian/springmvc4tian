package com.tian.bean;


import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class DubboNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("service", new DubboBeanDefinitionParser());
        registerBeanDefinitionParser("zookeeper", new DubboBeanDefinitionParser());
    }
}
