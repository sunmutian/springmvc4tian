package com.tian.springmvc.annotation;

import javax.annotation.Resources;
import java.lang.annotation.*;

/**
 * Qualifier注解
 *
 * @author tianweichang
 * @date 2018-08-08 10:36
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Qualifier {
    String value();
}
