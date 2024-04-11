package com.cui.cn.annotation;

import java.lang.annotation.*;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-10-18:12
 */
@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    int value() default 1;

    String name() default "";

    Class<?> [] c();

}
