package com.tian.bean;

import com.tian.config.Service;
import com.tian.config.ZookeeperConfig;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class DubboBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    private Class<?> beanClass;

    public DubboBeanDefinitionParser(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    protected Class getBeanClass(Element element) {
        return this.beanClass;
    }

    protected void doParse(Element element, BeanDefinitionBuilder bean, Class<?> beanClass) {
        if (ZookeeperConfig.class.equals(beanClass)) {
            String host = element.getAttribute("host");
            if (!StringUtils.isEmpty(host)) {
                bean.addPropertyValue("host", host);
            }
            String port = element.getAttribute("port");
            if (!StringUtils.isEmpty(port)) {
                bean.addPropertyValue("port", port);
            }
        }
        if (Service.class.equals(beanClass)) {
            String className = element.getAttribute("className");
            if (!StringUtils.isEmpty(className)) {
                bean.addPropertyValue("className", className);
            }
            String methodName = element.getAttribute("methodName");
            if (!StringUtils.isEmpty(methodName)) {
                bean.addPropertyValue("methodName", methodName);
            }
            String version = element.getAttribute("version");
            if (!StringUtils.isEmpty(version)) {
                bean.addPropertyValue("version", version);
            }
        }
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        doParse(element, bean, beanClass);
    }
}
