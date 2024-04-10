package com.cui.cn.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-07-13:09
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {

        ReflectTest rt = new ReflectTest();
        rt.methodT();
    }

    // 泛型的擦除
    public void methodT() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 创建泛型为String类型的集合
        List<String> list = new ArrayList<>();
        list.add("AA");
        list.add("BB");
        list.add("CC");
        list.add(1,"11");
        Class<? extends List> aClass = list.getClass();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(list,"字符串");
        add.invoke(list,123);
        add.invoke(list,true);
        System.out.println(list);

    }

    public void methodMethod() throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Class<?> sc = Class.forName("com.cui.cn.reflect.Student");
        Student s = (Student)sc.newInstance();
        Method[] declaredMethods = sc.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {

            if(declaredMethod.getName().equals("methodPrivate")){
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(s,"123",100);
            }else{
                declaredMethod.invoke(s);
            }


        }
    }

    public void constructorMethod() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Student student = new Student();
        Class<? extends Student> sc = student.getClass();
        // Target annotation = sc.getAnnotation(Target.class);
        // boolean annotation = sc.isAnnotation();
        //Annotation[] annotations = sc.getAnnotations();
        Constructor<?>[] declaredConstructors = sc.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
            declaredConstructor.setAccessible(true);

        }
        Constructor<? extends Student> constructor = sc.getConstructor(String.class,String.class);
        //constructor.setAccessible(true);
        Student student1 = constructor.newInstance("123","321");
        System.out.println(student1);

    }

    public void fieldMethod() throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        Class<Student> sc = Student.class;
        Student student = sc.newInstance();
        Field desc = sc.getField("desc");
        Field[] fields = sc.getFields();
        Field name1 = sc.getDeclaredField("name");
        Field[] declaredFields = sc.getDeclaredFields();
        Annotation[] annotations = sc.getAnnotations();
        /*boolean annotationPresent = sc.isAnnotationPresent(Resource.class);
        desc.set(sc,"sss");
        Object o = desc.get(desc);*/
        System.out.println(Arrays.toString(declaredFields));
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            System.out.println(name);
            declaredField.setAccessible(true);
            declaredField.set(student,name+" 100");
            Object o = declaredField.get(student);
            System.out.println(o);

        }

    }

    public void classMethod() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class<?> sc1 = Class.forName("com.cui.cn.reflect.Student");
        Student s1 = (Student)sc1.newInstance();
        System.out.println(s1);

        Class<Student> sc2 = Student.class;
        Student s2 = sc2.newInstance();
        System.out.println(s2);

        Student s = new Student();
        Class<? extends Student> sc3 = s.getClass();
        Student s3 = sc3.newInstance();
        System.out.println(s3);

    }
}
