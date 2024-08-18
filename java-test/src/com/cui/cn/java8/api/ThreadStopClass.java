package com.cui.cn.java8.api;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-13-22:03
 */
public class ThreadStopClass implements Runnable{

    private boolean flag = true;

    @Override
    public void run() {

        System.out.println("执行任务");
        while(flag){
            System.out.println("任务结束");
        }
    }

    public void stop(boolean flag){
        this.flag = flag;
    }
}
