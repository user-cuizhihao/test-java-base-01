package com.cui.cn.java8.juc;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-29-16:37
 * 公共资源类
 */
public class AllSourcesClass01 {


    public synchronized void methodSources07(){

        System.out.println(this + " is inner");
        AllSourcesClass01 c = new AllSourcesClass01();
        System.out.println(c + " is c");
        c.methodSources06();
        System.out.println(Thread.currentThread().getName() + " - methodSources07 - " + " 方法");

    }

    public synchronized void methodSources06(){

        System.out.println(Thread.currentThread().getName() + " - methodSources06 - " + " 方法");

    }

    public synchronized void methodSources05(){

        try {
            System.out.println("methodSources05执行开始");
            Thread.sleep(5000);
            System.out.println("methodSources05执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void methodSources04(){

        try {
            System.out.println("methodSources04开始执行");
            Thread.sleep(5000);
            System.out.println("methodSources04执行结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Integer number = 10; // 商品数量

    public void methodSources03() {

        while (true) {
            synchronized (this) {
                if(number <= 0){
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "获得了商品：" + number-- + "号");
            }
        }

    }

    public synchronized void methodSources01() {

        for (int i = 100; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
        // System.out.println(Thread.currentThread().getName() + " 线程执行了任务");
    }

    public void methodSources02() {

        System.out.println(Thread.currentThread().getName() + ": 开始选衣服");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": 选好了衣服");

        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName() + ": 开始试衣服");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + ": 试好了衣服");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
