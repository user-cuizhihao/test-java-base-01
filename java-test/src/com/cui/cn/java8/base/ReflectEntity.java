package com.cui.cn.java8.base;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-03-17:24
 */
public class ReflectEntity extends Thread{

    private String name;

    public String desc;

    public ReflectEntity() {
        this.name = "初始化name";
        this.desc = "初始化desc";
        System.out.println("公开无参构造方法");
    }

    private ReflectEntity(String name){
        this.name = name;
        System.out.println("私有构造方法");
    }

    public ReflectEntity(String name, String desc) {
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

    @Override
    public void run() {
        System.out.println("这是线程run方法");
    }

    public void method(){
        System.out.println("这是带注解的method方法");
    }

}
