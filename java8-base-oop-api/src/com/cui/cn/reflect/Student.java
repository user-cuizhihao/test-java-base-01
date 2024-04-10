package com.cui.cn.reflect;

import javax.annotation.Resource;

@Resource
public class Student /*extends Thread*/{

    private String name;

    @Deprecated
    public String desc;

    public Student() {
        System.out.println("公开无参构造方法");
    }

    private Student(String name){
        this.name = name;
        System.out.println("私有构造方法");
    }

    public Student(String name, String desc) {
        this.name = name;
        this.desc = desc;
        System.out.println("公开有参构造方法");
    }

    private void methodPrivate(String name,Integer age){
        System.out.println("这是私有方法："+name+"年纪："+age);
    }

    public void methodPublic(){
        System.out.println("这是公有方法");
    }

 /*   @Override
    public void run() {
        System.out.println("这是线程run方法");
    }*/

    public void method(){
        System.out.println("这是带注解的method方法");
    }
}