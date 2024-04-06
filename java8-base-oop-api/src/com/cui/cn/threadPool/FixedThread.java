package com.cui.cn.threadPool;

import java.util.concurrent.*;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-06-12:52
 */
public class FixedThread {

    public static void main(String[] args) {

        FixedThread fixedThread = new FixedThread();
        fixedThread.method07();
    }

    public void method07(){

        ExecutorService executorService = method06();
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + finalI);
                }
            });
        }
    }

    /**
     * 自定义线程池
     */
    public ExecutorService method06(){

        ExecutorService executorService = new ThreadPoolExecutor(
                5, // 核心线程数
                10, // 最大线程数
                30, // 线程存活时间
                TimeUnit.SECONDS, // 超出核心线程的线程存活时间，秒
                new LinkedBlockingDeque<>(), // 任务队列
                new ThreadPoolExecutor.DiscardPolicy(){
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                        System.out.println(e.getActiveCount());
                    }
                }
        );
        return executorService;
    }

    public void method05(){

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("定时任务");
            }
        },2,3,TimeUnit.SECONDS);

        /*ScheduledFuture<?> tow1 = scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 延时2秒执行");
            }
        }, 2, TimeUnit.SECONDS);*/

    }

    public void method04(){

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();
        for (int i = 0; i < 5; i++) {
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName()+ " 开始执行");
                System.out.println(Thread.currentThread().getName()+ " 处理业务逻辑");
                System.out.println(Thread.currentThread().getName()+ " 执行结束");
            });
        }

    }

    /**
     * 方式三：
     */
    public void method03(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();
        for (int i = 0; i < 100; i++) {
            executorService.submit(new MyThreadRunnable());
        }
    }

    /**
     * 方式二：固定线程数量的线程池
     */
    public void method02(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();
        for (int i = 0; i < 10; i++) {
            executorService.submit(myThreadRunnable);
        }
    }

    /**
     * 方式一：使用自定义的线程来创建线程数
     */
    public void method01(){
        MyThreadFactory myThreadFactory = new MyThreadFactory("oh god：");
        ExecutorService executorService = Executors.newFixedThreadPool(5, myThreadFactory);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }

}
