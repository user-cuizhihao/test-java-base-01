package com.cui.cn.java8.api;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-18-17:50
 */
public class ThreadClass03 implements Runnable{

    private Test_Java8_01 tj;

    public Test_Java8_01 getTj() {
        return tj;
    }

    public void setTj(Test_Java8_01 tj) {
        this.tj = tj;
    }

    public ThreadClass03(Test_Java8_01 tj) {
        this.tj = tj;
    }

    public ThreadClass03(){

    }

    @Override
    public void run() {

        method04();

    }

    private Integer number = 10;

    private ReentrantLock lock = new ReentrantLock();

    public void method04(){

        while (true){
            try{
                lock.lock();
                if(number <= 0){
                    break;
                }else{
                    System.out.println(Thread.currentThread().getName() + " 买了 " + number--+"号票");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static synchronized void method03(){

        for (int i = 30; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + ": "+ i);
        }

    }

    public void method02(){

        synchronized(ThreadClass03.class){
            for (int i = 30; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + ": "+ i);
            }
        }

    }
    public void method01(){

        synchronized(tj){
            for (int i = 30; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + ": "+ i);
            }
        }

    }
}
