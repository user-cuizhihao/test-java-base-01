package com.cui.cn.java8.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AllSourcesClass12 {

    // 创建 Map 集合
    private volatile Map<String,Object> map = new HashMap<>();
    // 创建读写锁
    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    // 存数据
    public void put(String key,Object value){

        // 添加写锁
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " -处理业务，开始存数据");
            TimeUnit.MICROSECONDS.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + " -业务处理完成，数据存完");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放写锁
            rwLock.writeLock().unlock();
        }
    }

    // 取数据
    public Object get(String key){

        // 添加读锁
        rwLock.readLock().lock();
        Object result = null;
        try {
            System.out.println(Thread.currentThread().getName() + " -取数据");
            TimeUnit.MICROSECONDS.sleep(300);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + " -数据取出");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放写锁
            rwLock.readLock().unlock();
        }
        return result;
    }
}