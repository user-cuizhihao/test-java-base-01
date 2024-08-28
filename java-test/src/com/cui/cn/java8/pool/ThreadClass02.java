package com.cui.cn.java8.pool;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-21-22:06
 */
public class ThreadClass02 /*extends Thread*/ implements Runnable{

    public static Integer count = 0;

    @Override
    public void run() {
        method01();
    }

    private synchronized void method01(){
        //synchronized (ThreadClass02.class){
            count++;
        //}
    }
}
