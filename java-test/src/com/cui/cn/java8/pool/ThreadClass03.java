package com.cui.cn.java8.pool;

import java.util.concurrent.Callable;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-24-11:13
 */
public class ThreadClass03 implements Callable<String> {

    @Override
    public String call() throws Exception {

        System.out.println("66");
        return "1111111111";
    }
}
