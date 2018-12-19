package com.tian.annotation;

import java.lang.annotation.*;

/**
 * @auther: lawt
 * @date: 2018/12/15 21
 * @Description: 自定义注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    Class<?> value();
}
