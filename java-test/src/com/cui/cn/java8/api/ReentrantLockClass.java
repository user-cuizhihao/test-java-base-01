package com.cui.cn.java8.api;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-15-15:44
 */
public class ReentrantLockClass implements Runnable{

    // 定义票数
    private Integer task = 10;

    // 定义锁
    private Lock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while(true){
            try{
                //System.out.println("刚进入while，在锁之前"+Thread.currentThread()+": "+task);
                lock.lock(); // 加锁
                if(task <= 0){
                    break;
                }else{
                    System.out.println(Thread.currentThread() + ": " + task--);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock(); // 释放锁
            }
        }
    }
}
