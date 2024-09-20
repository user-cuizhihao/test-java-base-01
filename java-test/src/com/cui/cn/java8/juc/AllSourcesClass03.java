package com.cui.cn.java8.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AllSourcesClass03 {

    // 线程间共同操作一个变量来完成通信
    private Integer numberWN = 0;
    public synchronized void methodAdd() throws InterruptedException {

        while(numberWN != 0){
            // 当前线程进入等待队列，并释放锁
            wait();
        }
        // 操作数据
        numberWN++;
        System.out.println(Thread.currentThread().getName() + " " + numberWN);
        // 唤醒当前锁对象中等待队列的线程
        notify();
    }

    public synchronized void methodDe() throws InterruptedException {

        while(numberWN != 1){
            // 当前线程进入等待队列，并释放锁
            wait();
        }
        // 操作数据
        numberWN--;
        System.out.println(Thread.currentThread().getName() + " " + numberWN);
        // 唤醒当前锁对象中等待队列的线程
        notify();
    }

    private final Lock lock = new ReentrantLock();
    public void method07(){

        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " - method07() 开始执行");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " - method07() 执行结束");
        } finally {
            lock.unlock();
        }
    }

    public void method06(){

        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " - method06() 开始执行");
            try {
                Thread.sleep(5000);
                method07();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " - method06() 执行结束");
        } finally {
            lock.unlock();
        }
    }

    public synchronized void method05(){
        System.out.println(Thread.currentThread().getName() + " - method05() 开始执行");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " - method05() 执行结束");
    }

    public synchronized void method04(){
        System.out.println(Thread.currentThread().getName() + " - method04() 开始执行");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " - method04() 执行结束");
    }

    private static final Lock l3 = new ReentrantLock();
    public static void method03() {

        try {
            l3.lock();
            System.out.println(Thread.currentThread().getName() + " 开始执行业务");
            Thread.sleep(2500); // 业务指执行时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " 业务执行结束");
            l3.unlock();
        }
    }

    private final Lock l2 = new ReentrantLock();
    public void method02() {

        try {
            boolean thisLock = l2.tryLock();
            //boolean thisLock = l2.tryLock(5, TimeUnit.SECONDS);
            if (thisLock) {
                System.out.println(Thread.currentThread().getName() + "开始处理业务");
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(Thread.currentThread().getName() + "业务处理失败");
        } finally {
            System.out.println(Thread.currentThread().getName() + "业务处理完成");
            l2.unlock();
        }
    }

    private static Integer number = 10;
    private final Lock l = new ReentrantLock();
    public void method01() {

        while (true) {
            try {
                l.lock();
                if (number <= 0) {
                    break;
                }
                //System.out.println(this);
                System.out.println(Thread.currentThread().getName() + " - 获得了 " + number-- + " 号票");
            } finally {
                l.unlock();
            }
        }
    }

    public static void method01_1() {

        Lock l = new ReentrantLock();
        while (true) {
            synchronized (number) {
                l.lock();
                if (number <= 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " - 获得了 " + number-- + " 号票");
            }
        }
    }

}
