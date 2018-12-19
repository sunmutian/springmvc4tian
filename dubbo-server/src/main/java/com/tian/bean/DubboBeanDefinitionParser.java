package com.tian.bean;

import com.tian.config.ZookeeperConfig;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class DubboBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class getBeanClass(Element element) {
        return ZookeeperConfig.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String host = element.getAttribute("host");
        if (!StringUtils.isEmpty(host)) {
            bean.addPropertyValue("host", host);
        }
        String port = element.getAttribute("port");
        if (!StringUtils.isEmpty(port)) {
            bean.addPropertyValue("port", port);
        }
    }
}
