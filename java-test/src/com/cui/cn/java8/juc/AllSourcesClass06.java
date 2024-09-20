package com.cui.cn.java8.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 86183 - cuizhihao
 * @create 2024-09-09-10:04
 */
public class AllSourcesClass06 {

    // 定义公共变量
    private Integer number = 0;
    // 定义 Lock 和 Condition
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // 操作公共变量加1
    public void incr() {

        try {
            lock.lock();
            while (number > 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + " - 为：" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 操作公共变量减1
    public void decr() {

        try {
            lock.lock();
            while (number <= 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + " - 为：" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
