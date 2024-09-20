package com.cui.cn.java8.juc;

import java.util.concurrent.*;

/**
 * @author 86183 - cuizhihao
 * @create 2024-09-19-14:36
 */
public class Queue01 {

    /**
     * 自定义线程池
     */
    public void methodThreadPool05(){

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, // 核心线程数
                10, // 最大线程数
                3l,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                //Executors.defaultThreadFactory(), // 创建默认线程池
                new ThreadPoolExecutor.AbortPolicy() // 拒绝策略
        );

        for (int i = 0; i < 15; i++) {
            threadPoolExecutor.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }

        threadPoolExecutor.shutdown();

    }

    /**
     * 可以执行周期任务的线程池
     */
    public void methodThreadPool04(){

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            scheduledExecutorService.schedule(()->{
                System.out.println(Thread.currentThread().getName());
            },3L, TimeUnit.SECONDS);
        }
        scheduledExecutorService.shutdown();
    }

    /**
     * 无界限线程池
     */
    public void methodThreadPool03(){

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + " 无边界线程池");
            });
        }
        executorService.shutdown();
    }

    /**
     * 只有一个线程的线程池
     */
    public void methodThreadPool02(){

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName() + " 执行任务");
            });
        }
        executorService.shutdown();

    }

    /**
     * 定长线程池
     */
    public void method0ThreadPool01(){

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
    }

}
