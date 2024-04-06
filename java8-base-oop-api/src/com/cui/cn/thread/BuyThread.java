package com.cui.cn.thread;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-02-17:04
 */
public class BuyThread implements Runnable{

    private Integer number = 10;
    private Boolean flag = true;

    @Override
    public void run() {
        while(flag){
            buy();
        }
    }

    private synchronized void buy() {

        if(number <= 0){
            flag = false;
            return;
        }

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+" 买到了票： "+ number-- + "号");

    }

}
