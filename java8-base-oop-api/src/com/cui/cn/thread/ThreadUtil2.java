package com.cui.cn.thread;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-01-11:08
 */
public class ThreadUtil2 implements Runnable {

    private boolean flag = true;
    private int i = 0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (flag) {
            System.out.println("--------------------------数据："+i++);
        }
    }

    public void stop() {
        this.flag = false;
    }
}
