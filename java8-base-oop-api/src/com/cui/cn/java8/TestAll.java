package com.cui.cn.java8;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-14-8:32
 */
public class TestAll {

    public static void main(String[] args) {

        TestAll ta = new TestAll();
        ta.method05();
    }

    public void method05(){

        ConsumerCopy<String,Integer> s123 = String::charAt;
        s123.copyMethod("123",1);


        Consumer<String> con = FunctionTestClass::consumeMethod;
        con.accept("soimmmm");

        Supplier<String> s = FunctionTestClass::suplierMethod;
        String s1 = s.get();
        System.out.println(s1);

        Function<String ,String> f12 = FunctionTestClass::staticMethod01;
        String apply1 = f12.apply("1");
        System.out.println(apply1);

        Comparator<Integer> compare = Integer::compare;
        int compare1 = compare.compare(1, 2);
        System.out.println(compare1);

        FunctionTestClass ftc = new FunctionTestClass();
        // 函数型
        Function<Integer,String> f = ftc::functionMethod;
        String apply = f.apply(56789);
        System.out.println(apply);

        // 断定型
        Predicate<Integer> p = ftc::booleanMethod;
        boolean test = p.test(166);
        System.out.println(test);
    }
    
    public void method04(){

        FunctionTestClass ftc = new FunctionTestClass();
        Consumer<String> consumer = ftc::setMethod;
        consumer.accept("123");
        Emp e = new Emp();
        Consumer<Integer> c1 = e::setZhiji;
        c1.accept(66);
        Supplier<Integer> s1 = e::getZhiji;
        Integer integer = s1.get();
        System.out.println(integer);

        /*Emp e = new Emp();
        e.setZhiji(1);
        Supplier<Integer> s = e::getZhiji;
        Integer integer = s.get();
        System.out.println(integer);*/
    }

    public void method03(){

        Consumer c = s -> {
            System.out.println(s);
        };
        c.accept("qqq");

    }

    public void method02(){

        /*LambdaFunction01 la = (i)->{
            return "321"+i;
        };
        String s = la.method03(3);
        System.out.println(s);*/

        /*int a = 10;
        LambdaFunction01 la = new LambdaFunction01() {
            @Override
            public void method02(Integer i) {
                System.out.println(i);
            }
        };
        la.method02(a);*/
    }

    public void method01(){

        Function<String, String> function = new Function<String, String>() {

            @Override
            public String apply(String s) {
                System.out.println(123);
                return null;
            }
        };

        /*LambdaFunction01 lambdaFunction01 = ()->{
            System.out.println("123");
        };
        lambdaFunction01.method01();*/

    }
}
