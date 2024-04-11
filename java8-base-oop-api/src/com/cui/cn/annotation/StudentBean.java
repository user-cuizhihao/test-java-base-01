package com.cui.cn.annotation;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-10-18:22
 */
public class StudentBean {

    @CheckOut
    public void jia(){
        System.out.println("1+1= " + (1+1));
    }

    @CheckOut
    public void jian(){
        System.out.println("1-1= " + (1-1));
    }

    @CheckOut
    public void cheng(){
        System.out.println("1*1= " + (1*1));
    }

    @CheckOut
    public void chu(){
        System.out.println("1/0 = " + (1/0));
    }
}
