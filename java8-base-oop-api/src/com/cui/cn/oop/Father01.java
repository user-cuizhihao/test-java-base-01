package com.cui.cn.oop;

import java.math.BigDecimal;

public class Father01 {

    public Father01() {
        System.out.println("父类构造方法");
    }

    public void onlyMethod(){

        System.out.println("父类独有的放法");
    }

    public void publicMethod(){

        System.out.println("父类public普通方法");
    }

    public BigDecimal bdMethod(){

        System.out.println("父类BigDecimal方法");
        return new BigDecimal("100.91");
    }

    private void privateMethod(){

        System.out.println("父类private普通方法");
    }

    public static String staticMethod(){

        return "父类静态方法";
    }

    public final Integer finalMethod(){

        System.out.println("被final修饰的父类方法");
        return 100;
    }
}
