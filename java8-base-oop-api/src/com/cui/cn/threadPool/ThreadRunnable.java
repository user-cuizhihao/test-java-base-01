package com.cui.cn.threadPool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-06-12:26
 */
public class ThreadRunnable{

    public static void main(String[] args) {
        MyThreadFactory thread = new MyThreadFactory("你好：");
        thread.newThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"123");
            }
        }).start();
    }
}

class MyThreadRunnable implements Runnable {

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName()+" 开始执行");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" 结束执行");
    }
}

class MyThreadFactory implements ThreadFactory {

    private AtomicInteger threadIdx = new AtomicInteger(0);

    private String threadNamePrefix;

    public MyThreadFactory(String Prefix) {
        threadNamePrefix = Prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(threadNamePrefix + "-xxljob-" + threadIdx.getAndIncrement());
        return thread;
    }
}
