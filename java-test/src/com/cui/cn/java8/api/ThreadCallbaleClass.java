package com.cui.cn.java8.api;

import java.util.concurrent.Callable;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-13-20:50
 */
public class ThreadCallbaleClass implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Integer a = 10;
        Integer b = 10;
        Integer c = a+b;
        System.out.println("1");
        return c;
    }
}
