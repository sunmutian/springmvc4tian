package com.tian.springmvc.annotation;

import java.lang.annotation.*;

/**
 * RequestMapping注解
 *
 * @author tianweichang
 * @date 2018-08-08 10:36
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {

    String value();
}
