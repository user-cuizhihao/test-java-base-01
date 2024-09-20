package com.cui.cn.java8.juc;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-13-20:56
 */
public class Test01 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Test01 t = new Test01();
        t.method46();
    }

    /**
     * 自定义线程池
     */
    public void method47(){



    }

    public void method46(){

        Queue01 q = new Queue01();
        // q.method0ThreadPool01();
        // q.methodThreadPool02();
        // q.methodThreadPool03();
        q.methodThreadPool05();

    }

    public void method45() throws InterruptedException {

        // 定义基于数组的定长阻塞队列
        // 定义数组的长度为3
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(3);
        /**
         * 超时 插入 移除 检查
         */
        bq.offer("a");
        bq.offer("b");
        bq.offer("c");
        // 队列满时，3秒后自动放弃加入队列
        //bq.offer("dd",3L,TimeUnit.SECONDS);

        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        // 队列空时，三秒后自动防区取数据，并返回null
        System.out.println(bq.poll(3L,TimeUnit.SECONDS));



        /**
         * 阻塞 插入 移除 检查
         */
        /*bq.put("a");
        bq.put("b");
        bq.put("c");
        // 超出队列长度时，阻塞等待，等待队列中有元素被取出
        // bq.put("dd");

        // 移除队列元素，并返回
        System.out.println(bq.take());
        System.out.println(bq.take());
        System.out.println(bq.take());
        // 队列为空时，阻塞等待，等待队列中存入元素
        System.out.println(bq.take());*/

        /**
         * 特殊值 插入 移除 检查
         */
        /*System.out.println(bq.offer("a"));
        System.out.println(bq.offer("b"));
        System.out.println(bq.offer("c"));
        // 超出队列范围添加失败返回false
        // System.out.println(bq.offer("dd"));

        // 检查
        //System.out.println(bq.peek()); // 返回队列第一个元素

        // 移除
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        // 队列为空，返回null
        System.out.println(bq.poll());*/

        /**
         * 抛出异常的 插入 移除 检查
         */
        /*System.out.println(bq.add("a")); // 添加成功返回true,添加失败返回false
        System.out.println(bq.add("b"));
        System.out.println(bq.add("c"));
        // 超出数组的指定长度，抛出异常
        // System.out.println(bq.add("dd"));

        // 检查
        //System.out.println(bq.element());

        // 移除
        System.out.println(bq.remove()); // 移除成功返回移除的元素,移除失败报异常
        System.out.println(bq.remove());
        System.out.println(bq.remove());
        System.out.println(bq.remove("a")); // 指定元素移除时：移除成功返回true,移除失败返回false
        // 数组为空时移除报异常
        // System.out.println(bq.remove());*/

    }

    // 异步调用有返回值
    public void method44(){

        // 有返回值
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{

            System.out.println(Thread.currentThread().getName());
            // 创建一个异常，测试u的异常信息
            // int i = 1/0;
            // 返回值
            return 1024;
        });
        completableFuture.whenComplete((t,u)->{
            // 返回值
            System.out.println("----t = "+t); // 1024
            // 异常信息，如果代码中出现异常，u打印的是异常信息
            System.out.println("----u = "+u); // u异常信息
        });
    }

    public void method43() throws ExecutionException, InterruptedException {

        // 异步调用，米有返回值
        // 泛型为Void表示没有返回值
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());
        });

        completableFuture.get();
    }

    public void method42() throws ExecutionException, InterruptedException {

        // 创建任务对象
        int [] data = new int[]{1,2,3,4,5,6,7,8,9,10}; //55
        MyArrayTask01 myArrayTask = new MyArrayTask01(0,data.length-1,data);
        // 创建分支合并池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 反省为void表示没有返回值
        ForkJoinTask<Void> forkJoinTask = forkJoinPool.submit(myArrayTask);
        // 此处阻塞是等待分支合并池中的线程执行完，拿到结果积
        Thread.sleep(1500);
        // 获取值
        int result = MyArrayTask01.AccumulatorHelper.getResult();
        System.out.println(result);
        // 关闭分支合并池
        //forkJoinPool.shutdown();
    }

    public void method41() throws ExecutionException, InterruptedException {

        // 创建任务对象
        int [] data = new int[]{1,2,3,4,5,6,7,8,9,10}; //55
        MyArrayTask myArrayTask = new MyArrayTask(0,data.length-1,data);
        // 创建分支合并池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> f = forkJoinPool.submit(myArrayTask);
        Integer integer = f.get();
        System.out.println(integer);

        // 关闭分支合并池
        //forkJoinPool.shutdown();

    }

    public void method40() throws ExecutionException, InterruptedException {

        // 创建分支对象
        MyTask myTask = new MyTask(1,100);
        // 创建分支合并池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> f = forkJoinPool.submit(myTask);
        Integer integer = f.get();
        System.out.println(integer);

        // 关闭线程池
        //forkJoinPool.shutdown();
    }

    private Integer a;
    public void method39(){
        System.out.println(a);
    }

    public void method38() throws ExecutionException, InterruptedException {

        // 创建分支任务对象
        MyForkJoin mfj = new MyForkJoin(1,100);
        // 创建池对象,并执行
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(mfj);
        // 获取结果只
        Integer integer = forkJoinTask.get();
        System.out.println(integer);
        // 关闭池
        forkJoinPool.shutdown();
    }

    public void method37(){

        int result = 0;
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
            result+=i;
        }
        System.out.println(result);
    }

    public void method36(){

        int result = 0;
        for (int i = 1; i <= 100; i++) {
            result+=i;
        }
        System.out.println(result);
    }

    // 读锁降级示例
    public void method35(){

        // 创建读写锁对象
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        // 创建写锁
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
        // 创建读锁
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();

        // 2. 添加读锁
        readLock.lock();
        System.out.println("RL - 执行读锁中的内容");

        // 1. 添加写锁
        writeLock.lock();
        System.out.println("WL - 执行写锁中的内容");

        // 3. 释放写锁
        writeLock.unlock();
        System.out.println("WL - 释放写锁");

        // 4. 释放读锁
        readLock.unlock();
        System.out.println("RL - 释放读锁");

    }

    public void method34(){

        AllSourcesClass12 a = new AllSourcesClass12();

        // 取数据
        for (int i = 1; i <= 5; i++) {
            final Integer number = i;
            new Thread(()->{
                a.get(number+"");
            },String.valueOf(i)).start();
        }

        // 存数据
        for (int i = 1; i <= 5; i++) {
            final Integer number = i;
            new Thread(()->{
                a.put(number+"",number+"");
            },String.valueOf(i)).start();
        }

    }

    public void method33(){

        // 创建 Semaphore 对象，并设置许可数量
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    // 当前线程抢占停车位
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+" 拥有了停车位");
                    // 每辆车随机停留五秒内
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName()+" ---- 离开了停车位");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    // 释放停车位
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }

    private static final Integer NUMBER = 7;
    public void method32(){

        // 创建 CyclicBarrier 对象
        // 参数一：需要满足的条件
        // 参数二：条件满足后执行的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER,()->{
            System.out.println("七颗龙珠集齐，愿望实现");
        });

        for (int i = 1; i <= 7; i++) {
            new Thread(()->{

                try {
                    System.out.println("获得了 "+Thread.currentThread().getName() + " 颗龙珠");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }

    public void method31() throws InterruptedException {

        // 创建 CountDownLatch 的对象
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 号同学离开了教室");
                // 每个线程启动后计数器减1
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        // 在计数器不为0时阻塞线程
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " 班长关闭了教室");

    }

    public void method30() throws ExecutionException, InterruptedException {

        FutureTask<Integer> f = new FutureTask<Integer>(()->{
            System.out.println(11);
            return 10;
        });
        Thread t = new Thread(f);
        t.start();
        System.out.println(f.get());

    }

    public void method29(){

        AllSourcesClass11 a = new AllSourcesClass11();
        FutureTask<Integer> f = new FutureTask<>(a);
        Thread t = new Thread(f);
        t.start();
        /*try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

    }

    public void method28(){

        AllSourcesClass09 a = new AllSourcesClass09();
        new Thread("A"){
            @Override
            public void run() {
                a.method02();
            }
        }.start();

    }

    public void method27(){

        AllSourcesClass08 a = new AllSourcesClass08();
        new Thread("线程A："){
            @Override
            public void run() {
                a.methodMai();
            }
        }.start();

        new Thread("线程B："){
            @Override
            public void run() {
                a.methodMai();
            }
        }.start();

        new Thread("线程C："){
            @Override
            public void run() {
                a.methodMai();
            }
        }.start();
    }

    public void method26(){

        /*AllSourcesClass08 a8 = new AllSourcesClass08();
        new Thread("线程A："){
            @Override
            public void run() {
                try {
                    a8.method();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread("线程B："){
            @Override
            public void run() {
                a8.methodStatic();
            }
        }.start();*/

    }

    public void method25(){

        //Map<String,String> map = new HashMap<>();
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(" "+i){
                @Override
                public void run() {
                    map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,5));
                    System.out.println(map);
                }
            }.start();
        }
    }

    public void method24() {

        // Set<String> set = new HashSet<>();
        Set<String> set = new CopyOnWriteArraySet<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread() {
                @Override
                public void run() {
                    // 向集合中添加数据
                    set.add(UUID.randomUUID().toString().substring(0, 5));
                    // 读取集合中的数据
                    System.out.println(set);
                }
            }.start();
        }
    }

    public void method23() {

        // List<String> list = new ArrayList<>();
        // 解决方式一：
        // List<String> list = new Vector<>();
        // 解决方式二：
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 1000; i++) {
            new Thread() {
                @Override
                public void run() {
                    // 向集合中添加数据
                    list.add(UUID.randomUUID().toString().substring(0, 5));
                    // 读取集合中的数据
                    System.out.println(list);
                }
            }.start();
        }
    }

    public void method22() {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread("线程： " + i) {
                @Override
                public void run() {
                    list.add(Thread.currentThread().getName());
                }
            }.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        System.out.println(list.size());
    }

    public void method21() {

        AllSourcesClass07 a = new AllSourcesClass07();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    a.println5A(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    a.println10B(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    a.println15C(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }

    public void method20() {

        AllSourcesClass06 a1 = new AllSourcesClass06();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a1.incr();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a1.decr();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a1.incr();
            }
        }, "CC").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a1.decr();
            }
        }, "DD").start();

    }

    public void method19() {

        AllSourcesClass05 a1 = new AllSourcesClass05();
        AllSourcesClass05 a2 = new AllSourcesClass05();
        new Thread("1") {
            @Override
            public void run() {
                a1.method01();
            }
        }.start();

        new Thread("2") {
            @Override
            public void run() {
                a2.method02();
            }
        }.start();

    }

    public void method18() {

        AllSourcesClass05 allSourcesClass05 = new AllSourcesClass05();
        new Thread("1") {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    allSourcesClass05.add();
                }
            }
        }.start();
        new Thread("2") {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    allSourcesClass05.de();
                }
            }
        }.start();
        new Thread("3") {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    allSourcesClass05.de();
                }
            }
        }.start();
        new Thread("4") {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    allSourcesClass05.de();
                }
            }
        }.start();

    }

    public void method17() {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newSingleThreadExecutor();
        new ThreadPoolExecutor(
                5, // 核心线程数
                10, // 最大线程数
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return null;
                    }
                },
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                    }
                }
        );


    }

    public void method16() {

        AllSourcesClass03 a = new AllSourcesClass03();
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    a.methodAdd();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "a - ").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    a.methodDe();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "b - ").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    a.methodAdd();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "c - ").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    a.methodDe();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "d - ").start();
    }

    /**
     * 测试不可重入锁
     */
    public void method15() {

        AllSourcesClass04 a = new AllSourcesClass04();
        new Thread(() -> a.lockIs(), "a").start();
        new Thread(() -> a.unlockIs(), "b").start();
    }

    public void method14() throws InterruptedException {

        AllSourcesClass04 a = new AllSourcesClass04();
        new Thread(() -> {
            try {
                a.methodAdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                a.methodDe();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public void method13() {

        AllSourcesClass03 a = new AllSourcesClass03();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    a.methodAdd();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    a.methodDe();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void method12() {

        AllSourcesClass03 a = new AllSourcesClass03();
        new Thread(() -> a.method06()).start();
        new Thread(() -> a.method07()).start();

    }

    public void method11() {

        AllSourcesClass03 a = new AllSourcesClass03();
        AllSourcesClass03 b = new AllSourcesClass03();
        new Thread(() -> a.method04()).start();
        new Thread(() -> b.method05()).start();

    }

    public void method10() {

        AllSourcesClass03 a1 = new AllSourcesClass03();
        AllSourcesClass03 a2 = new AllSourcesClass03();
        Thread t1 = new Thread(() -> a1.method02(), "a ");
        Thread t2 = new Thread(() -> a2.method02(), "b ");
        t1.start();
        t2.start();

    }

    public void method09() throws InterruptedException {

        AllSourcesClass03 a = new AllSourcesClass03();
        Thread t1 = new Thread(() -> a.method02(), "a ");
        Thread t2 = new Thread(() -> a.method02(), "b ");
        t1.start();
        //Thread.sleep(1000); // 阻塞线程，保证第一个线程能够拿到锁
        t2.start();
        /*Thread.sleep(5000);
        Thread t3 = new Thread(() -> a.method02(), "c ");
        t3.start();*/
    }

    public void method08() {

        AllSourcesClass03 a = new AllSourcesClass03();
        new Thread(() -> a.method01(), "老1").start();
        new Thread(() -> a.method01(), "老A").start();
    }

    public void method07() {

        AllSourcesClass02 a = new AllSourcesClass02();
        a.methodA();
    }

    public void method06() {

        AllSourcesClass01 a = new AllSourcesClass01();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(a);
                a.methodSources07();
            }
        }, "线程A").start();

        //AllSourcesClass01 b = new AllSourcesClass01();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a.methodSources06();
            }
        }, "线程1").start();

    }

    public void method05() {

        AllSourcesClass01 a = new AllSourcesClass01();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a.methodSources04();
            }
        }, "线程A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a.methodSources05();
            }
        }, "线程1").start();
    }

    public void method04() {

        AllSourcesClass01 a = new AllSourcesClass01();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a.methodSources03();
            }
        }, "线程A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a.methodSources03();
            }
        }, "线程1").start();

    }

    public void method03() {

        AllSourcesClass01 a = new AllSourcesClass01();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a.methodSources02();
            }
        }, "线程A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a.methodSources02();
            }
        }, "线程1").start();

    }

    public void method02() {

        AllSourcesClass01 a = new AllSourcesClass01();

        Thread t1 = new Thread("线程1") {
            @Override
            public void run() {
                a.methodSources01();
            }
        };

        Thread t2 = new Thread("线程2") {
            @Override
            public void run() {
                a.methodSources01();
            }
        };

        t1.start();
        t2.start();

    }

    public void method01() {

        /*Thread t1 = new Thread(new PoolThreadClass01(),"线程1");
        Thread t2 = new Thread(new PoolThreadClass01(),"线程2");
        t1.start();
        t2.start();*/
    }

}
