package com.cui.cn.java8.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AllSourcesClass08 {

    private Integer number = 10;

    Lock lock = new ReentrantLock();

    public void methodMai(){
        while (true){
            try {
                lock.lock();
                if(number <= 0){
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + number-- + " :号票");
            } finally {
                lock.unlock();
            }
        }
    }

}
