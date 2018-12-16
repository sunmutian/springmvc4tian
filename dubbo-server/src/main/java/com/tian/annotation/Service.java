package com.tian.annotation;

import java.lang.annotation.*;

/**
 * @auther: tianweichang
 * @date: 2018/12/15 21
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    Class<?> value();
}
