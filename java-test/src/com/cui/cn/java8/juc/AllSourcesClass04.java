package com.cui.cn.java8.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 86183 - cuizhihao
 * @create 2024-09-03-11:22
 */
public class AllSourcesClass04 {

    /**
     * 不可重入锁的实现
     */
    private Boolean isLock = false;
    public synchronized void lockIs(){

        while (isLock){
            try {
                // 当头其他线程获得该锁时，
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // ...  // 业务逻辑执行
        System.out.println("方法lockIs() " + Thread.currentThread().getName() + " - 执行了");
        isLock = true;
    }

    public synchronized void unlockIs(){

        // ...  // 业务逻辑
        lockIs();  // 死循环无尽的等待
        System.out.println("方法unlockIs() " + Thread.currentThread().getName() + " - 执行了");
        // 判断标识赋值，并唤醒其他线程
        isLock = false;
        notify();
    }

    /**
     * 线程间通信
     */
    private final Lock l = new ReentrantLock();

    // 线程间共同操作一个变量来完成通信
    private Integer numberWN = 0;
    public void methodAdd() throws InterruptedException {

        try {
            l.lock();
            if(numberWN != 0){
                // 当前线程进入等待队列，并释放锁
                wait();
            }
            // 操作数据
            numberWN++;
            System.out.println(Thread.currentThread().getName() + " " + numberWN);
            // 唤醒当前锁对象中等待队列的线程
            notify();
        } finally {
            l.unlock();
        }
    }

    public void methodDe() throws InterruptedException {

        try {
            l.lock();
            if(numberWN != 1){
                // 当前线程进入等待队列，并释放锁
                wait();
            }
            // 操作数据
            numberWN--;
            System.out.println(Thread.currentThread().getName() + " " + numberWN);
            // 唤醒当前锁对象中等待队列的线程
            notify();
        } finally {
            l.unlock();
        }
    }

}
