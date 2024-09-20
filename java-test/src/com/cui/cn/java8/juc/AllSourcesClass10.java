package com.cui.cn.java8.juc;

/**
 * @author 86183 - cuizhihao
 * @create 2024-09-13-14:36
 */
public class AllSourcesClass10 {

    // 定义两个公共资源
    private static Object a = new Object();
    private static Object b = new Object();

    public static void main(String[] args) {

        new Thread("线程A "){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "获取了a资源，尝试获取b资源");
                    try {
                        Thread.sleep(1500); // 增大不确定性
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b){
                        System.out.println(Thread.currentThread().getName() + "获取了b资源");
                    }
                }
            }
        }.start();

        new Thread("线程B "){
            @Override
            public void run() {
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "获取了b资源，尝试获取a资源");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (a){
                        System.out.println(Thread.currentThread().getName() + "获取了a资源");
                    }
                }
            }
        }.start();
    }

}
