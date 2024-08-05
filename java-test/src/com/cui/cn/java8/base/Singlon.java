package com.cui.cn.java8.base;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-05-14:44
 */
public class Singlon {

    // 私有的构造方法
    private Singlon(){

    }

    private static final Singlon singlon = new Singlon();

    public static Singlon getInstance(){
        return singlon;
    }

}
