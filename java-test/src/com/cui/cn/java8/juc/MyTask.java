package com.cui.cn.java8.juc;

import java.util.concurrent.RecursiveTask;

/**
 * @author 86183 - cuizhihao
 * @create 2024-09-18-9:26
 */
public class MyTask extends RecursiveTask<Integer> {

    // 定义判断条件,拆分的差值不能超过10
    private static final Integer VALUE = 10;
    private int begin; // 定义起始值
    private int end; // 定义结束值
    private int result; // 定义结果值

    // 创建有参构造方法
    public MyTask(int begin,int end) {
        this.begin = begin;
        this.end = end;
    }

    // 拆分和合并任务
    @Override
    protected Integer compute() {
        // 判断相加的书的范围是否大于10
        if(end - begin <= 10){
            // 合并任务的结果
            for (int i = begin; i <= end; i++) {
                result += i;
            }
        }else{ // 拆分逻辑
            // 定义中间值
            int middle = (begin + end)/2;
            // 定义左边拆分对象
            MyTask taskLeft = new MyTask(begin,middle);
            // 定义右边拆分对象
            MyTask taskRight = new MyTask(middle+1,end);
            // 拆分分支
            taskLeft.fork();
            taskRight.fork();
            result = taskLeft.join() +taskRight.join();
        }
        return result;
    }
}
