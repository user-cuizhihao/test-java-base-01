package com.cui.cn.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-29-17:28
 */
public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadTest tt = new ThreadTest();
        tt.method15();
    }

    public void method15() throws InterruptedException {

        //List<String> list = new Vector<>();
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= 20000; i++) {
            new Thread(){
                @Override
                public void run() {
                    //synchronized (ThreadTest.class){
                        set.add(Thread.currentThread().getName());
                    //}
                }
            }.start();
        }
        Thread.sleep(10000);
        System.out.println(set.size());

    }

    public void method14(){

        BuyThread bt = new BuyThread();
        Thread thread1 = new Thread(bt,"老三");
        Thread thread2 = new Thread(bt,"老四");
        Thread thread3 = new Thread(bt,"老五");

        thread2.setPriority(10);

        thread1.start();
        thread2.start();
        thread3.start();

    }

    public void method13(){

        Runnable runnable = new Runnable() {

            private Integer number = 10;

            private ReentrantLock lock = new ReentrantLock();
            @Override
            public void run() {

                while (true){
                    System.out.println(Thread.currentThread().getName());
                    lock.lock();
                    if(number > 0){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+" 操作数据：" + number--);
                    }else{
                        System.out.println("结束");
                        break;
                    }
                    System.out.println(Thread.currentThread().getName());
                    lock.unlock();
                }

            }
        };

        Thread thread1 = new Thread(runnable,"线程1");
        Thread thread2 = new Thread(runnable,"线程2");

        thread1.start();
        thread2.start();

    }

    public void method12(){

        //SynTest synTest = new SynTest();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SynTest synTest = new SynTest();
                synTest.method03();
            }
        };

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                SynTest synTest = new SynTest();
                synTest.method03();
            }
        };

        Thread thread1 = new Thread(runnable,"线程1");
        Thread thread2 = new Thread(runnable1,"线程2");

        //Thread thread3 = new Thread(runnable1,"线程3");

        thread1.start();
        thread2.start();
        //thread3.start();

    }

    public void method11(){

        SynTest synTest = new SynTest();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                try {
                    synTest.method01();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                try {
                    synTest.method02();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread1.start();
        thread2.start();

    }

    private void method(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " is " + i);
        }
    }

    public void method10() {

        Runnable runnable = new Runnable() {
            private Integer number = 10;
            @Override
            public synchronized void run() {
                while(true){
                    if (number <= 0) {
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 售卖了" +number-- + "号票");
                }
            }
        };

        Thread thread1 = new Thread(runnable,"窗口1");
        Thread thread2 = new Thread(runnable,"窗口2");
        thread1.start();
        thread2.start();
    }

    public void method09() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "开始选衣服");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName() + "选衣服结束");
                    synchronized (this) {
                        System.out.println("拿到了房间钥匙" + Thread.currentThread().getName() + "+开始试衣服");
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName() + "选衣试服结束");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread1 = new Thread(runnable, " 线程1 ");
        Thread thread2 = new Thread(runnable, " 线程2 ");

        thread1.start();
        thread2.start();
    }

    public void method08() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        };

        new Thread(runnable, "1 = ").start();
        new Thread(runnable, "2 = ").start();
    }

    public void method07() {

        ThreadUtil2 threadUtil2 = new ThreadUtil2();
        Thread thread = new Thread(threadUtil2);
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("--" + i);
            if (i == 999) {
                System.out.println("--" + i);
                threadUtil2.stop();
            }
        }
    }

    public void method06() {

        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("help~~~~jack...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("biu --- biu");
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("我在这儿");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.setDaemon(true);

        thread.start();
        thread1.start();


    }

    public void method05() {

        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "thread 线程: " + i);
                    if (i == 5) {
                        Thread.yield();
                    }
                }
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "runnable 线程: " + i);

                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        Thread thread1 = new Thread(runnable);

        thread.setName("thread线程 ");
        thread1.setName("runnable线程 ");

        thread.setPriority(10);

        thread.start();
        thread1.start();
    }

    public void method04() {

        Thread thread = Thread.currentThread();
        thread.setName("线程1");
    }

    public void method03() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " this is : " + i);
                }
            }
        };

        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " oh my god : " + i);
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.setName("runnable线程");

        thread1.start();
        thread.start();
        thread.setName("thread线程");

    }

    public void method02() {

        /*CallableUtil cu = new CallableUtil();
        FutureTask<Integer> ft = new FutureTask<Integer>(cu);
        Thread thread1 = new Thread(ft);
        RunnableUtil ru = new RunnableUtil();
        Thread thread2 = new Thread(ru);
        thread1.start();
        thread2.start();
        String [] str = {"你","好","呀"};
        for (int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }*/

        //Integer integer = ft.get();
        //System.out.println(integer);



        /*ThreadUtil tu = new ThreadUtil();
        tu.start();*/

    }

    public void method01() {

        // 获取 Java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }

    }

}
