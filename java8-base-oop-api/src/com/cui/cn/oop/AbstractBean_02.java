package com.cui.cn.oop;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-19-10:20
 */
public class AbstractBean_02 extends AbstractBean_01{

    @Override
    public String stringMethod() {

        return "wocao";
    }

    @Override
    public void me() {
        System.out.println("02");
    }

    @Override
    public void voidMethod() {

        System.out.println("voidMethod");
    }

    public void method01(){
        System.out.println("独有");
    }
}
