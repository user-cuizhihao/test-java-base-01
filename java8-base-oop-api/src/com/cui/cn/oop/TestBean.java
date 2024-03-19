package com.cui.cn.oop;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-18-4:12
 */
public class TestBean {

    public static void main(String[] args) {

        // 向下转向
        Father01 father01 = new Son01();
        father01.publicMethod();
        father01.bdMethod();

        // 子类对象
        /*Son01 son01 = new Son01("aaaa");
        son01.onlyMethod();*/
        /*son01.publicMethod();
        BigDecimal bigDecimal = son01.bdMethod();
        System.out.println(bigDecimal);
        son01.method002();
        Integer integer = son01.finalMethod();
        System.out.println(integer);
        String s = Son01.staticMethod();
        System.out.println(s);*/

        /*ThisBean tb = new ThisBean();
        tb.method01("this is : "+tb.toString());
        ThisBean tb1 = new ThisBean();
        tb.method01("this is : "+tb1.toString());*/

        /*StudentBean sb1 = new StudentBean();
        sb1.setUuid(1001);
        StudentBean sb2 = new StudentBean();
        sb2.setUuid(100);
        System.out.println(sb1);
        System.out.println(sb2);

        System.out.println(sb1.hashCode());
        System.out.println(sb2.hashCode());

        System.out.println(sb1.equals(sb2));*/
    }

    public void method01(){

    }

}
