package com.cui.cn.java8.base;

/**
 * @author 86183 - cuizhihao
 * @create 2024-07-16-17:14
 */
public class ThisTest {

    static{
        System.out.println("静态块");
    }


    {
        System.out.println("块");
    }

    public ThisTest() {
        System.out.println("构造方法");
    }

    public void method01(int a){

        if(a == 10){
            this.method02();
        }
        System.out.println("写了一顿逻辑");
    }

    public void method02(){

        System.out.println("这里是独立的一段逻辑");
    }

}
