package com.cui.cn.java8.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-03-22:05
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationMy {

    int number() default 1;

    String name();

    Class<? extends Number> classI();

    String [] names();

    EnumIsMy02 [] ENUM_IS_MY_02_S();

}
