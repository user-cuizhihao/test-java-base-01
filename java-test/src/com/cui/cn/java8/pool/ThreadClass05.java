package com.cui.cn.java8.pool;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-26-15:44
 */
public class ThreadClass05 implements Runnable{

    @Override
    public void run() {
        //try {
            //System.out.println(Thread.currentThread().getName() + "开始执行任务");
            //Thread.sleep(500);
            this.method01();
            //System.out.println(Thread.currentThread().getName() + "任务执行结束");
        /*} catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    public void method01(){
        System.out.println(Thread.currentThread().getName() + "方法执行");
    }
}
