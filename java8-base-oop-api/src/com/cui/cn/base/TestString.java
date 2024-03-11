package com.cui.cn.base;

public class TestString {

    public static void main(String[] args) {

        TestString t1 = new TestString();
        int i = t1.method001();
        int i1 = t1.method002();
        System.out.println(i1);
        System.out.println(i);
    }

    public int method001(){
        int i = 1;
        int a = (++i) + (++i);
        System.out.println(i);
        return a;
    }

    public int method002(){

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        return 0;
    }

}

