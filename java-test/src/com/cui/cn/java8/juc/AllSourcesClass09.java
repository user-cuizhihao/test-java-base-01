package com.cui.cn.java8.juc;

/**
 * @author 86183 - cuizhihao
 * @create 2024-09-13-13:59
 */
public class AllSourcesClass09 {

    private Boolean flag = false;

    public synchronized void method01() {

        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " : is method01");
        flag = true;
        notify();
    }

    public synchronized void method02(){

        while (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        method01();
        System.out.println(Thread.currentThread().getName() + " : is method02");
        flag = false;
        notify();
    }


}
