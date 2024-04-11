package com.cui.cn.enumAndMathT;

import java.math.BigDecimal;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-12-2:03
 */
public class MathTest {

    public static void main(String[] args) {

        MathTest mt = new MathTest();
        mt.method03();
    }

    public void method03(){

        double a = 1.3;
        double b = 1.1;
        System.out.println(a+b);

        BigDecimal bg1 = new BigDecimal(Double.toString(a));
        BigDecimal bg2 = new BigDecimal(Double.toString(b));
        System.out.println(bg1.add(bg2));

    }

    public void method01() {
        double random = Math.random();
        System.out.println((int) (random * 10));

        long round = Math.round(-1.5);
        System.out.println(round);

    }

}
