package com.cui.cn.annotation;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-10-19:09
 */
public class TestBean {

    public static void main(String[] args) throws NoSuchMethodException {

        TestBean tb = new TestBean();
        tb.method01();
    }

    public void method01() throws NoSuchMethodException {

        Class<TestAnnotation> tac = TestAnnotation.class;
        boolean annotationPresent = tac.isAnnotationPresent(MyAnnotation.class);
        if(annotationPresent){
            MyAnnotation annotation = tac.getAnnotation(MyAnnotation.class);
            String name = annotation.name();
            System.out.println(name);
        }
        Method method01 = tac.getMethod("method01");
        boolean annotationPresent1 = method01.isAnnotationPresent(MyAnnotation.class);
        if(annotationPresent1){
            MyAnnotation annotation = method01.getAnnotation(MyAnnotation.class);
            String name = annotation.name();
            System.out.println(name);
            Class<?>[] c = annotation.c();
            System.out.println(Arrays.toString(c));

        }
    }

}
