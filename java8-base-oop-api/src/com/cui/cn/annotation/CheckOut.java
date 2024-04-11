package com.cui.cn.annotation;

import java.lang.annotation.*;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-11-13:08
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckOut {
}
