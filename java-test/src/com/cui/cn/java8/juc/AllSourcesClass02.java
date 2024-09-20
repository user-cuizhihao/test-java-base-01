package com.cui.cn.java8.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-30-16:49
 */
public class AllSourcesClass02 {

    private Lock l1 = new ReentrantLock();
    private Lock l2 = new ReentrantLock();

    Integer a = 100;

    public void methodA(){

        try {
            boolean b = l1.tryLock();
            if(b){
                try {
                    boolean b1 = l2.tryLock();
                    if(b1){
                        System.out.println("1111");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                 l2.unlock();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            l1.unlock();
        }

    }

}
