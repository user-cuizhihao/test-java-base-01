package com.cui.cn.java8.api;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-18-15:32
 */
public class ThreadClass01 implements Runnable{

    @Override
    public void run() {
        for (int i = 10000; i > 0; i--) {
            System.out.println("线程方法");
        }
        System.out.println("线程方法");
    }
}
