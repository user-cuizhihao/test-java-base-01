package com.cui.cn.java8.pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-24-11:32
 */
public class ThreadClass04 implements ThreadFactory {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private String threadNamePrefix;

    public ThreadClass04(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,threadNamePrefix + " - " + atomicInteger.getAndIncrement());
        return t;
    }

}
