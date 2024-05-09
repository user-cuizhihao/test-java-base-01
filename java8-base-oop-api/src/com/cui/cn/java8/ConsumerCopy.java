package com.cui.cn.java8;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-15-15:29
 */
@FunctionalInterface
public interface ConsumerCopy<T,R> {

    void copyMethod(T t,R r);

}
