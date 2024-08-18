package com.cui.cn.java8.api;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-14-14:49
 */
public class ThreadRunnableClass01 implements Runnable {

    @Override
    public void run() {

        method05();
        //this.method01();
        /*try {
            method03();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //ThreadRunnableClass01.method04();
    }

    public void method05(){

        synchronized (this){
            for (int i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread()+": "+i);
            }
        }
    }

    public static synchronized void method04(){

        for (int i = 10; i > 0; i--) {
            System.out.println(Thread.currentThread() + ": " + i);
        }
    }

    private Integer number = 10;

    public void method03() throws InterruptedException {

        synchronized (this) {
            while (true) {
                Thread.sleep(1000); // 增大不确定性
                if (number <= 0) {
                    break;
                } else {
                    System.out.println(Thread.currentThread() + ": 买走了" + number-- + "号商品");
                }
            }
        }
    }

    public void method02() throws InterruptedException {

        System.out.println(Thread.currentThread() + ": 开始选衣服");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread() + ": 选好了衣服");

        synchronized (this) {
            System.out.println(Thread.currentThread() + ": 开始时衣服");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread() + ": 试好了衣服");
        }
    }

    public synchronized void method01() {

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread() + ": " + i);
        }
    }
}
