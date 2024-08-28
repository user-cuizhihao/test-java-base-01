package com.cui.cn.java8.pool;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-18-22:41
 */
public class ThreadClass01 implements Runnable{

    private static Kou kou = new Kou();
    private static Jing jing = new Jing();

    int change; // 0 镜子；1 口红
    String name;

    public ThreadClass01(int change, String name) {
        this.change = change;
        this.name = name;
    }

    @Override
    public void run() {

        es();

    }

    public void es(){

        if(change == 0){
            synchronized (jing){
                System.out.println(Thread.currentThread().getName()+"获得了镜子");
                try{
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            synchronized (kou){
                System.out.println(Thread.currentThread().getName()+"获得了口红");
            }
        }else{
            synchronized (kou){
                System.out.println(Thread.currentThread().getName()+"获得了口红");
                try{
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            synchronized (jing){
                System.out.println(Thread.currentThread().getName()+"获得了镜子");
            }
        }

    }

}

class Kou{

}

class Jing{

}
