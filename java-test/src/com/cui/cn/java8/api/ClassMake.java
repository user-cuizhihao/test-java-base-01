package com.cui.cn.java8.api;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-15-21:05
 */
public class ClassMake extends Thread{

    static ClassJing cj = new ClassJing();
    static ClassKou ck = new ClassKou();

    // 0：表示镜子，1：表示口红
    int choose = 0;
    String name = null;

    public ClassMake(int choose, String name) {
        this.choose = choose;
        this.name = name;
    }

    @Override
    public void run() {

        if(choose == 0){
            synchronized (cj){
                System.out.println(Thread.currentThread().getName() + "：获取了镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (ck){
                System.out.println(Thread.currentThread().getName()+"：获得了口红");
            }
        }else{
            synchronized (ck){
                System.out.println(Thread.currentThread().getName() + "：获取了口红");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (cj){
                System.out.println(Thread.currentThread().getName()+"：获得了镜子");
            }
        }
    }
}
