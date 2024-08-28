package com.cui.cn.java8.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-18-22:51
 */
public class Tes {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Tes t = new Tes();
        t.method15();
    }

    public void method15(){

        ExecutorService es = new ThreadPoolExecutor(
                1,
                2,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1),
                new ThreadClass06("前缀"),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        /*Thread t = new Thread(r,"处理");
                        t.start();*/
                        BlockingQueue<Runnable> queue = executor.getQueue();
                        try {
                            queue.put(r);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        for (int i = 0; i < 21; i++) {
            es.submit(new ThreadClass05());
        }

    }

    public void method14(){

        ExecutorService es = new ThreadPoolExecutor(
                5,
                7,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3)
        );

        for (int i = 10; i > 0; i--) {
            es.submit(new ThreadClass05());
        }
    }

    // 定长线程池
    public void method13(){

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(5, new ThreadClass06("前缀"));
        for (int i = 0; i < 7; i++) {
            ses.scheduleAtFixedRate(()-> System.out.println(Thread.currentThread().getName()),1,3,TimeUnit.SECONDS);
        }

        /*ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 7; i++) {
            scheduledExecutorService.schedule(()-> System.out.println(Thread.currentThread().getName()),5,TimeUnit.SECONDS);
        }*/
    }

    // 单线程化的线程池
    public void method12(){

        ExecutorService executorService = Executors.newSingleThreadExecutor(new ThreadClass06("前缀"));
        for (int i = 0; i < 7; i++) {
            executorService.submit(()-> System.out.println(Thread.currentThread().getName()));
        }

        /*ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 7; i++) {
            executorService.submit(new ThreadClass05());
        }*/
    }

    // 无界限线程池
    public void method11(){

        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadClass06("前缀"));
        for (int i = 0; i < 7; i++) {
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }

        /*ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 7; i++) {
            executorService.submit(new ThreadClass05());
        }*/
    }

    // 指定数量的线程池
    public void method10(){

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 7; i++) {
            executorService.submit(new ThreadClass05());
        }

        /*ExecutorService es = Executors.newFixedThreadPool(5, new ThreadClass06("前缀"));
        for (int i = 0; i < 7; i++) {
            es.submit(new ThreadClass05());
        }*/
    }

    public void method09(){

        ThreadClass06 t6 = new ThreadClass06("前缀名");
        ThreadClass05 t5 = new ThreadClass05();
        Thread thread = t6.newThread(t5);
        thread.start();
    }

    public void method08(){

        ThreadClass04 tc4 = new ThreadClass04("线程");
        Thread thread = tc4.newThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        });
        thread.start();
    }

    public void method07() throws ExecutionException, InterruptedException {

        ThreadClass03 tc3 = new ThreadClass03();
        FutureTask<String> f = new FutureTask(tc3);
        Thread t = new Thread(f);
        t.start();
        String o =  f.get();
        System.out.println(o);
    }

    public void method06(){

        ThreadClass02 t = new ThreadClass02();
        for (int i = 10000; i > 0; i--) {
            new Thread(t).start();
        }
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(ThreadClass02.count);
    }

    public void method05(){

        int count = 0;
        for (int i = 10000; i > 0; i--) {
            count++;
        }
        System.out.println(count);
    }

    public void method04(){

        /*for (int i = 10000; i > 0; i--) {
            new ThreadClass02().start();
        }
        try {
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(ThreadClass02.count);*/
    }

    //static int count = 0;
    AtomicInteger ai = new AtomicInteger(0);
    public void method03(){

        for (int i = 100000; i > 0; i--) {
            new Thread(){
                @Override
                public void run() {
                    //synchronized (Tes.class){
                        //count ++;
                        ai.getAndIncrement();
                    //}
                }
            }.start();
        }
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println(count);
        System.out.println(ai);
    }

    public void method02(){

        AtomicInteger threadIdx = new AtomicInteger(0);
        int andIncrement = threadIdx.getAndIncrement();
        System.out.println(andIncrement);
    }

    public void method01(){

        ThreadClass01 t1 = new ThreadClass01(0,"晓红");
        ThreadClass01 t2 = new ThreadClass01(1,"小明");
        Thread t3 = new Thread(t1);
        Thread t4 = new Thread(t2);
        t3.start();
        t4.start();
    }

}
