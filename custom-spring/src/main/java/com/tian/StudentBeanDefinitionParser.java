package com.tian;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * StudentBeanDefinitionParser class
 * 解析student标签
 *
 * @author Java后端技术栈
 * @date 2018/09/25
 */
public class StudentBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class getBeanClass(Element element) {
        return Student.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String name = element.getAttribute("name");
        String age = element.getAttribute("age");
        String id = element.getAttribute("id");

        if (StringUtils.hasText(id)) {
            bean.addPropertyValue("id", Integer.valueOf(id));
        }
        if (StringUtils.hasText(name)) {
            bean.addPropertyValue("name", name);
        }
        if (StringUtils.hasText(age)) {
            bean.addPropertyValue("age", Integer.valueOf(age));
        }
    }
}