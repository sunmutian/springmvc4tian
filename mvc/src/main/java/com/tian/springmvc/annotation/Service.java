package com.tian.springmvc.annotation;

import java.lang.annotation.*;

/**
 * Service注解
 *
 * @author tianweichang
 * @date 2018-08-08 10:36
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Service {
    String value();
}
