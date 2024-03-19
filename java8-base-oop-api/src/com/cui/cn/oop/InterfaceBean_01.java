package com.cui.cn.oop;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-19-11:01
 */
public interface InterfaceBean_01 {

    public static final Integer id = 100;

    public abstract void methodAbs01();

    default void methodDe(){

    }

    public static void methodStatic(){

    }

}
