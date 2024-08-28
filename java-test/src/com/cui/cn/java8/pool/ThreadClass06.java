package com.cui.cn.java8.pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-26-15:46
 */
public class ThreadClass06 implements ThreadFactory {

    // 咸亨安全的Integer原子类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    // 定义线程名称前缀
    private String fixName;

    // 在创建对象时就定义线程名称的前缀
    public ThreadClass06(String fixName){
        this.fixName = fixName;
    }

    @Override
    public Thread newThread(Runnable r) {

        Thread t = new Thread(r);
        t.setName("线程工厂" + " - " + this.fixName + " - " + atomicInteger.getAndIncrement());
        return t;
    }
}
