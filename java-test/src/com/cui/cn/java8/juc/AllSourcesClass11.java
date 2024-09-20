package com.cui.cn.java8.juc;

import java.util.concurrent.Callable;

/**
 * @author 86183 - cuizhihao
 * @create 2024-09-13-16:44
 */
public class AllSourcesClass11 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("12345678910");
        return 110;
    }
}
