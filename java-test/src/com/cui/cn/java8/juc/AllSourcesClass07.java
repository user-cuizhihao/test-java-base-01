package com.cui.cn.java8.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 86183 - cuizhihao
 * @create 2024-09-09-11:17
 */
public class AllSourcesClass07 {

    // 定义全局表示
    private Integer flag = 1; // 1：A, 2：B, C：3

    // 定义 Lock
    private Lock lock = new ReentrantLock();

    // 为每一个线程定义一个,用来控制这条线程的 休眠和唤醒 状态。
    private Condition c1 = lock.newCondition(); // 线程A
    private Condition c2 = lock.newCondition(); // 线程B
    private Condition c3 = lock.newCondition(); // 线程C

    // 参数表示第几轮循环
    public void println5A(Integer loop) throws InterruptedException {

        try {
            // 加锁
            lock.lock();
            // 判断；如果标识不为1，则此线程A休眠
            if(flag != 1){
                c1.await();
            }
            // 干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+" :: "+i+" :: 轮数："+loop);
            }
            // 通知
            flag =  2; // 标识改为2
            c2.signal(); // 唤醒B线程
        } finally {
            // 解锁
            lock.unlock();
        }
    }

    // 参数表示第几轮循环
    public void println10B(Integer loop) throws InterruptedException {

        try {
            // 加锁
            lock.lock();
            // 判断；如果标识不为2，则此线程B休眠
            if(flag != 2){
                c2.await();
            }
            // 干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+" :: "+i+" :: 轮数："+loop);
            }
            // 通知
            flag =  3; // 标识改为3
            c3.signal(); // 唤醒C线程
        } finally {
            // 解锁
            lock.unlock();
        }
    }

    // 参数表示第几轮循环
    public void println15C(Integer loop) throws InterruptedException {

        try {
            // 加锁
            lock.lock();
            // 判断；如果标识不为3，则此线程C休眠
            if(flag != 3){
                c3.await();
            }
            // 干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+" :: "+i+" :: 轮数："+loop);
            }
            // 通知
            flag =  1; // 标识改为1
            c1.signal(); // 唤醒A线程
        } finally {
            // 解锁
            lock.unlock();
        }
    }

}
