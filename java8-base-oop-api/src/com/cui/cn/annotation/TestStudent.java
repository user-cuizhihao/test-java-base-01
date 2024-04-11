package com.cui.cn.annotation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-11-13:27
 */
public class TestStudent {

    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {

        TestStudent ts = new TestStudent();
        ts.methodThreadPool();
    }

    public void methodThreadPool() throws IOException {

        ThreadPoolExecutor threadPoolExecutor = methodPoolExecutor();
        for (int i = 0; i < 20; i++) {
            int fi = i;
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 当前线程执行的数据为： " +" " + fi);
                }
            });
        }
    }

    public ThreadPoolExecutor methodPoolExecutor() throws IOException {

        String path = "D:"+File.separator+"fileTest"+File.separator+"log.txt";
        PrintWriter pw = new PrintWriter(new FileWriter(new File(path)));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(5),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        Thread thread = new Thread(r);
                        pw.println(thread.toString());
                        pw.flush();
                        pw.close();
                        thread.start();
                    }
                }
        );
        return threadPoolExecutor;
    }

    public void method() throws IOException, InvocationTargetException, IllegalAccessException {

        String path = "D:"+File.separator+"fileTest"+File.separator+"log.txt";
        PrintWriter pw = new PrintWriter(new FileWriter(new File(path)));

        StudentBean stu = new StudentBean();
        Class<? extends StudentBean> aClass = stu.getClass();
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            try {
                method.invoke(stu);
            }catch (Exception e){
                pw.write("报错方法: "+method.toString());
                pw.println(e.getMessage());
                pw.println(e.toString());
                pw.println(e.getLocalizedMessage());
                pw.flush();
                pw.close();
                e.printStackTrace();
            }
        }
    }
}