package com.tian.springmvc.annotation;

import java.lang.annotation.*;

/**
 * @author tianweichang
 * @date 2018-08-08 11:04
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Repository {
    String value();
}
