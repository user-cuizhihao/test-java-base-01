package com.cui.cn.oop;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-18-5:03
 */
public class ThisBean {

    public void method01(String s){
        String s1 = this.method02(s);
        System.out.println(s1);
    }

    public String method02(String str){
        return str;
    }

}
