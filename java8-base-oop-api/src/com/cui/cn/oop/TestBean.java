package com.cui.cn.oop;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-18-4:12
 */
public class TestBean {

    public static void main(String[] args) {

        StudentBean sb1 = new StudentBean();
        sb1.setUuid(1001);
        StudentBean sb2 = new StudentBean();
        sb2.setUuid(100);
        System.out.println(sb1);
        System.out.println(sb2);

        System.out.println(sb1.hashCode());
        System.out.println(sb2.hashCode());

        System.out.println(sb1.equals(sb2));
    }

    public void method01(){

    }

}
