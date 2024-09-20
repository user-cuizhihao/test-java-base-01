package com.cui.cn.java8.juc;

import java.util.concurrent.RecursiveTask;

/**
 * @author 86183 - cuizhihao
 * @create 2024-09-18-14:45
 */
public class MyArrayTask extends RecursiveTask<Integer> {

    // 定义条件，最小分支不超过五个元素
    private static final int VALUE = 5;
    private int begin; // 开始元素下标
    private int end; // 结束元素下标
    private int result; // 结果值
    // 定义目标数组
    private int[] data;

    public MyArrayTask(int begin, int end, int[] data) {
        this.begin = begin;
        this.end = end;
        this.data = data;
    }

    @Override
    protected Integer compute() {
        // 判断元素的个数是否不超过5个
        if (end - begin <= 5) {
            for (int i = begin; i <= end; i++) {
                result += data[i];
            }
        }else{
            // 定义中间值
            int middle = (begin+end)/2;
            // 定义左边数组
            MyArrayTask myArrayLeft = new MyArrayTask(begin,middle,data);
            // 定义右边数组
            MyArrayTask myArrayRight = new MyArrayTask(middle+1,end,data);
            // 执行分支
            myArrayLeft.fork();
            myArrayRight.fork();
            // 合并结果积
            result = myArrayLeft.join() + myArrayRight.join();
        }
        return result;
    }
}
