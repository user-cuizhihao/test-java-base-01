package com.cui.cn.java8.api;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-13-20:02
 */
public class ThreadClass extends Thread{

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println("这是一个任务类"+i);
        }

    }

}
