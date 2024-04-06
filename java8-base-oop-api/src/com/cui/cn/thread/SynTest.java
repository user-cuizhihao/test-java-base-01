package com.cui.cn.thread;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-02-10:53
 */
public class SynTest {

    public static void method03(){
        synchronized (SynTest.class){
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+" 数据："+i);
            }
        }
    }

    public synchronized void method01() throws InterruptedException {
        System.out.println("method01....开始");
        Thread.sleep(5000);
        System.out.println("method01....结束");
    }

    public synchronized void method02() throws InterruptedException {
        System.out.println("method02....开始");
        Thread.sleep(5000);
        System.out.println("method02....结束");
    }
}
