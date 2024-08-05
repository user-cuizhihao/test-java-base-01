package com.cui.cn.java8.base;

/**
 * @author 86183 - cuizhihao
 * @create 2024-07-17-17:14
 */
public class Father01 {

    private String name;

    private String desc;

    public final String fatherAttr="father";

    public Father01(){
        System.out.println("父类无参构造方法");
    }

    public void method01(){
        System.out.println("父类的方法");
    }

    public Integer method03(){

        return 10;
    }

    public final void method02(){
        System.out.println("父类独有的方法");
    }

    public static void method04(){

        System.out.println("父类静态方法");
    }
}
