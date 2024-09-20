package com.cui.cn.java8.juc;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 86183 - cuizhihao
 * @create 2024-09-18-15:36
 */
public class MyArrayTask01 extends RecursiveAction {

    // 定义条件，最小分支不超过五个元素
    private static final int VALUE = 5;
    private int begin; // 开始元素下标
    private int end; // 结束元素下标
    // 定义目标数组
    private int[] data;

    public MyArrayTask01(int begin, int end, int[] data) {
        this.begin = begin;
        this.end = end;
        this.data = data;
    }

    // 无返回值的任务
    @Override
    protected void compute() {

        // 判断元素的个数是否不超过5个
        if (end - begin <= 5) {
            for (int i = begin; i <= end; i++) {
                AccumulatorHelper.accumulate(data[i]);
            }
        } else {
            // 定义中间值
            int middle = (begin + end) / 2;
            // 定义左边数组
            MyArrayTask myArrayLeft = new MyArrayTask(begin, middle, data);
            // 定义右边数组
            MyArrayTask myArrayRight = new MyArrayTask(middle + 1, end, data);
            // 执行分支
            myArrayLeft.fork();
            myArrayRight.fork();
            // 合并结果积
            AccumulatorHelper.accumulate(myArrayLeft.join());
            AccumulatorHelper.accumulate(myArrayRight.join());
        }
    }

    // 静态内部类
    static class AccumulatorHelper {

        // 基本数据类型的原子类
        private static final AtomicInteger result = new AtomicInteger(0);

        static void accumulate(int value) {
            result.getAndAdd(value);
        }

        public static int getResult() {
            return result.get();
        }

        static void rest() {
            result.set(0);
        }
    }
}
