package com.cui.cn.java8.base;

/**
 * @author 86183 - cuizhihao
 * @create 2024-07-17-17:15
 */
public class FatherIsSon01 extends Father01{

    public final String fatherAttr="son";

    public FatherIsSon01() {

    }

    @Override
    public void method01() {
        System.out.println("子类");
    }

    @Override
    public Integer method03() {

        return 1000;
    }

    public void methodSon01(){
        System.out.println("子类独有的方法");
    }

    /*public static void method04(){

        System.out.println("子类静态方法");

    }*/
}
