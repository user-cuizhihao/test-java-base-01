package com.cui.cn.thread;

import java.util.concurrent.Callable;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-30-9:05
 */
public class CallableUtil implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        return null;
    }
}
