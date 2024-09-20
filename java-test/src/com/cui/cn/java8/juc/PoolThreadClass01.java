package com.cui.cn.java8.juc;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-29-16:12
 */
public class PoolThreadClass01{

    public static void main(String[] args) {

        PoolThreadClass01 p = new PoolThreadClass01();
        p.method01();
    }

    public void method01(){

        new Thread() {
            @Override
            public void run() {
                new SourcesClass(0, "雄安红").source();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                new SourcesClass(1, "小明").source();
            }
        }.start();
    }

}

// 资源整合类
class SourcesClass{

    private static Kou k = new Kou();
    private static Jing j = new Jing();

    Integer choose; // 0：kou；1：jing
    String name;

    public SourcesClass(Integer choose,String name){
        this.choose = choose;
        this.name = name;
    }

    public void source(){

        if(choose.equals(0)){
            synchronized (k){
                try {
                    System.out.println(this.name + " 拿到了口红");
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (j){
                System.out.println(this.name + " 拿到了镜子");
            }
        }else{
            synchronized (j){
                try {
                    System.out.println(this.name + " 拿到了镜子");
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (k){
                System.out.println(this.name + " 拿到了口红");
            }
        }
    }

}

// 资源类1
class Kou{

}

// 资源类2
class Jing{

}
