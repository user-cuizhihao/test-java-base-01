package com.cui.cn.thread;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-30-8:48
 */
public class ThreadUtil extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
