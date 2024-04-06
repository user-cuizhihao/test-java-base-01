package com.cui.cn.thread;

public class TestClass05 {

    public static void main(String[] args) {
        // 创建线程
        StopThread stopThread = new StopThread();
        new Thread(stopThread).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main "+i);
            if(i == 500){
                stopThread.stop(); // 停止线程
                System.out.println("-----------------------------------------线程该停止了");
            }
        }
    }
}

class StopThread implements Runnable{

    // 1. 定义一个标识
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        // 2. 线程体使用该标识
        while(flag){
            System.out.println(Thread.currentThread().getName()+" stop ------------------"+ i++);
        }
    }

    //3. 修改标识的值
    public void stop(){
        this.flag = false;
    }

}