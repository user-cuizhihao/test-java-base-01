package com.cui.cn.oop;

import java.math.BigDecimal;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-18-5:47
 */
public class Son01 extends Father01{

    private String name;

    public Son01() {
        System.out.println("子类构造方法");
    }

    public void method002(){
        System.out.println("子类独有的放法");
    }

    @Override
    public void publicMethod() {

        System.out.println("子类重写父类public普通方法");
    }

    @Override
    public BigDecimal bdMethod() {

        System.out.println("子类重写父类BigDecimal方法");
        return new BigDecimal("19090");
    }
}
