package com.cui.cn.java8.juc;

import java.util.concurrent.RecursiveTask;

/**
 * @author 86183 - cuizhihao
 * @create 2024-09-17-11:35
 */
public class MyForkJoin extends RecursiveTask<Integer> {

    // 拆分差值不能超过10，计算10以内的运算
    private static final Integer VALUE = 10;
    private int begin; // 拆分开始值
    private int end; // 拆分结束值
    private int result; // 拆分结果值

    // 创建有参构造方法
    public MyForkJoin(Integer begin, Integer end) {
        this.begin = begin;
        this.end = end;
    }

    // 拆分和合并过程
    @Override
    protected Integer compute() {
        // 判断相加的数的范围是否大于10
        if(end - begin <= VALUE){
            // 相加操作
            for (int i = begin; i <= end; i++) {
                result += i;
            }
        }else{ // 拆分逻辑
            // 获取数据中间值
            int middle = (end+begin)/2;
            // 拆分左边的对象
            MyForkJoin mfjLeft = new MyForkJoin(begin,middle);
            // 拆分右边的对象
            MyForkJoin mfjRight = new MyForkJoin(middle+1,end);
            // 调用拆分方法
            mfjLeft.fork();
            mfjRight.fork();
            result = mfjLeft.join() + mfjRight.join();
        }
        return result;
    }
}