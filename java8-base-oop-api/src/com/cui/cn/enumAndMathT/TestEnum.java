package com.cui.cn.enumAndMathT;

import java.util.Arrays;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-12-1:04
 */
public class TestEnum {

    public static void main(String[] args) {

        TestEnum te = new TestEnum();
        te.method03();
    }

    public void method03(){

        Integer i = EnumUtil.A.i();
        System.out.println(i);

        EnumUtil a = EnumUtil.A;
        System.out.println(a);

        String jByI = EnumUtil.A.getJByI(i);
        System.out.println(jByI);

    }

    public void method02(){

        EnumTest one1 = EnumTest.ONE;
        EnumTest one2 = EnumTest.ONE;
        EnumTest tow1 = EnumTest.TOW;
        System.out.println(one1.equals(one2));

        Class<EnumTest> declaringClass = EnumTest.ONE.getDeclaringClass();
        System.out.println(declaringClass);

        int ordinal = EnumTest.ONE.ordinal();
        System.out.println(ordinal);

        String name = EnumTest.ONE.name();
        System.out.println(name);

        EnumTest[] values = EnumTest.values();
        System.out.println(Arrays.toString(values));

        EnumTest tow = EnumTest.TOW;
        System.out.println(tow);

        String str01 = EnumTest.ONE.getStr01();
        System.out.println(str01);

        String str02 = EnumTest.TOW.getStr02();
        System.out.println(str02);
    }

    public void method01() {

        /*EnumTest one = EnumTest.ONE;
        System.out.println(one);

        String name = EnumTest.TOW.name();
        System.out.println(name);

        EnumTest name1 = EnumTest.valueOf("TOW");
        System.out.println(name1);*/
    }
}
