package com.cui.cn.java8.juc;

/**
 * @author 86183 - cuizhihao
 * @create 2024-09-09-9:16
 */
public class AllSourcesClass05 {


    public synchronized void method01(){

        System.out.println(Thread.currentThread().getName() + " 开始执行");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 执行结束");
    }

    public synchronized void method02(){

        System.out.println(Thread.currentThread().getName() + " 开始执行");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 开始结束");
    }

    private Integer number = 0;

    public synchronized void add(){

        while(number > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName() + " 号线程 " +number);
        notify();
    }

    public synchronized void de(){

        while(number <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName() + " 号线程 " +number);
        notify();
    }

}
