package com.cui.cn.thread;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-02-19:47
 */
public class DeadSync{

    public static void main(String[] args) {

        Make make1 = new Make(0,"小红");
        Make make2 = new Make(1,"小美");
        make1.start();
        make2.start();

    }

}

class Make extends Thread{

    static Kou kou = new Kou();
    static Jing jing = new Jing();

    int choose; // 0-口红；1-镜子
    String name;

    public Make(int choose,String name){
        this.name = name;
        this.choose = choose;
    }

    @Override
    public void run() {

        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void makeUp() throws InterruptedException {

        if(choose == 0){
            synchronized (kou){
                System.out.println(name+" 拿到口红");
                Thread.sleep(1000);
                synchronized (jing){
                    System.out.println(name+" 拿到镜子");
                }
            }

        }else{
            synchronized (kou){
                System.out.println(name+" 拿到口红");
                synchronized (jing){
                    System.out.println(name+" 拿到镜子");
                    Thread.sleep(1000);
                }
            }
        }

    }

}

/**
 * 口红类
 */
class Kou{

}

/**
 * 镜子类
 */
class Jing{

}
