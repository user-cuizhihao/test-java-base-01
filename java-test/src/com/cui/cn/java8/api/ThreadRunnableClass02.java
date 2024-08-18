package com.cui.cn.java8.api;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-15-20:23
 */
public class ThreadRunnableClass02 implements Runnable{

    // 停止线程的标识
    private Boolean flag = true;

    // 定义总票数
    private Integer number = 20;

    @Override
    public void run() {

        while(flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 卖票的方法
    public synchronized void buy() throws InterruptedException {

        if(number > 0){
            System.out.println(Thread.currentThread().getName() + ": " + number--);
        }else{
            flag = false;
        }
        Thread.sleep(1000);
    }

}
