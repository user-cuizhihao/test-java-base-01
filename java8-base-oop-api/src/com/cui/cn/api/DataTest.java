package com.cui.cn.api;

import java.time.LocalDateTime;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-21-11:02
 */
public class DataTest {

    public static void main(String[] args) {

        DataTest a = new DataTest();
        a.method02();
    }

    public void method02(){

        LocalDateTime l1 = LocalDateTime.of(2024,1,1,1,1,1);
        LocalDateTime l2 = LocalDateTime.of(2024,2,2,2,2,2);
        int i = l2.compareTo(l1);
        System.out.println(i);
    }

    private void method01(){

        String a = "123";
        int i = Integer.parseInt(a);
        System.out.println(i);

        String s = Integer.toString(123);
        System.out.println(s);

        Integer a1 = 1;
        Integer a2 = 127;
        System.out.println(a1.equals(a2));

        int i1 = a1.compareTo(a2);
        System.out.println(i1);
    }

}
