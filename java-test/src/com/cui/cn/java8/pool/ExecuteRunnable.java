package com.cui.cn.java8.pool;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-21-21:03
 */
public class ExecuteRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始任务");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "任务结束");
    }
}
