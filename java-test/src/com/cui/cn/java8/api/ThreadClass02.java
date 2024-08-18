package com.cui.cn.java8.api;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-18-17:49
 */
public class ThreadClass02 implements Runnable {

    @Override
    public void run() {

        // method01();

        /*try {
            method02();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        method03();
    }

    public /*synchronized*/ void method05(){

        System.out.println(Thread.currentThread().getName() +" method05 ~~~~~");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" method05 ~~~~~");

    }

    public /*synchronized*/ void method04(){

        System.out.println(Thread.currentThread().getName() +" method04 ~~~~~");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +" method04 ~~~~~");

    }

    private Integer number = 10;

    public void method03() {

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                if (number <= 0) {
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + ": 得到了" + number-- + "号票");
                }
            }
        }
    }

    public void method02() throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + ": 开始选衣服");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + ": 选好了衣服");
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + ": 开始~试~衣服");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": 试好了衣服");
        }
    }

    public synchronized void method01() {

        for (int i = 100; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
