package com.cui.cn.thread;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-30-8:50
 */
public class RunnableUtil implements Runnable{
    @Override
    public void run() {
        String str = "abcdefjhigklmn";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }
}
