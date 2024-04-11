package com.cui.cn.enumAndMathT;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-11-18:45
 * 单例模式：饿汉式
 */
public class SingleTest {

    private SingleTest(){}

    private static final SingleTest SINGLE_TEST = new SingleTest();

    public static SingleTest getSingleTest(){
        return SINGLE_TEST;
    }
}

class SingleT{
    public static void main(String[] args) {
        SingleTest singleTest1 = SingleTest.getSingleTest();
        SingleTest singleTest2 = SingleTest.getSingleTest();
        SingleTest singleTest3 = SingleTest.getSingleTest();
        System.out.println(singleTest1);
        System.out.println(singleTest2);
        System.out.println(singleTest3);
    }
}
