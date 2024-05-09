package com.cui.cn.java8;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-15-16:16
 */
public class FunctionTestClass {

    public void method02(String s,Integer i){
        char c = s.charAt(i);
        System.out.println(c);
    }

    public static void consumeMethod(String str){
        System.out.println(str);
    }

    public static String suplierMethod(){
        return "a";
    }

    public static String staticMethod01(String s){
        System.out.println("aaa");
        return s;
    }

    public String functionMethod(Integer i){
        return "转换："+i;
    }

    public boolean booleanMethod(Integer i){
        if(i.compareTo(167) >= 0){
            return true;
        }
        return false;
    }

    public void setMethod(String s){
        System.out.println("职位"+s);
    }

}
