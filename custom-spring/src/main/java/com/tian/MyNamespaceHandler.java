package com.tian;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * MyNamespaceHandler class
 *
 * @author Java后端技术栈
 * @date 2018/09/25
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());
        registerBeanDefinitionParser("student", new StudentBeanDefinitionParser());
    }
}