package com.cui.cn.java8.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

public class Test02 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        Test02 t = new Test02();
        t.method24();
    }

    public void method24(){

        double a = 3.1;
        double b = 3.2;
        System.out.println(a+b);

        BigDecimal b1 = new BigDecimal(a);
        BigDecimal b2 = new BigDecimal(b);
        BigDecimal add = b1.add(b2);
        System.out.println(add);

        BigDecimal b3 = new BigDecimal(String.valueOf(a));
        BigDecimal b4 = new BigDecimal(Double.toString(b));
        BigDecimal add1 = b3.add(b4);
        System.out.println(add1);

    }

    public void method23(){

        double pow = Math.pow(2, 3);
        System.out.println(pow);

    }

    public void method22(){

        double floor = Math.floor(-4.9);
        System.out.println(floor);
        double ceil = Math.ceil(-4.9);
        System.out.println(ceil);
        long round = Math.round(4.9);
        System.out.println(round);

    }
    
    public void method21(){
        
        String [] arrStr = new String[]{"red","red","red","ye","ye","write","write","write","write","write"};
        for (int i = 0; i < 100; i++) {
            int i1 = method19();
            String s = arrStr[i1];
            System.out.println(s);
        }
    }

    public void method20(){

        // key 球的颜色；value 球出现的次数
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            int i1 = method19();
            if (0 <= i1 && i1 <= 2){ // 红色
                if(map.containsKey("red")){
                    Integer red = map.get("red");
                    map.put("red",++red);
                }else{
                    map.put("red",1);
                }
            }else if(i1 == 3 || i1 == 4){
                if(map.containsKey("ye")){
                    Integer ye = map.get("ye");
                    map.put("ye",++ye);
                }else{
                    map.put("ye",1);
                }
            }else{
                if(map.containsKey("wri")){
                    Integer wri = map.get("wri");
                    map.put("wri",++wri);
                }else{
                    map.put("wri",1);
                }
            }
        }
        System.out.println(map);
    }

    public int method19(){
        // 0.0 =< random < 1.0
        int random = (int)(Math.random()*10);
        //System.out.println(random);
        // 红球 30% 黄球 20% 白球 50%
        // 0-2      3-4     5-9
        return random;
    }

    public void method18(){

        EnumFinal enumFinal = EnumFinal.setIGetEnum(3);
        //String name = enumFinal.name();
        //System.out.println(name);
        System.out.println(enumFinal);

        //Integer i = EnumFinal.A.i();
        /*System.out.println(i);
        String j = EnumFinal.A.j();
        System.out.println(j);
        EnumFinal[] values = EnumFinal.values();
        System.out.println(Arrays.toString(values));
        for (EnumFinal enumFinal : values) {
            if(enumFinal.i().equals(i)){
                System.out.println(enumFinal.j());
            }
        }*/

        /*String s = EnumFinal.setIGetJ(i);
        System.out.println(s);*/
        /*String j = EnumFinal.B.j();
        Integer integer = EnumFinal.setJGetI(j);
        System.out.println(integer);*/

    }

    public void method17(){

        EnumIsmY01[] values = EnumIsmY01.values();
        System.out.println(Arrays.toString(values));
        String number = EnumIsmY01.B.getStr();
        System.out.println(number);
        Integer number1 = EnumIsmY01.A.getNumber();
        System.out.println(number1);
        EnumIsmY01.A.setStr("213562");
        String str = EnumIsmY01.A.getStr();
        System.out.println(str);
        int ordinal = EnumIsmY01.A.ordinal();
        System.out.println(ordinal);
        EnumIsmY01 a = EnumIsmY01.A;
        EnumIsmY01 b = EnumIsmY01.A;
        boolean equals = a.equals(b);
        System.out.println(equals);
        Class<EnumIsmY01> declaringClass = EnumIsmY01.A.getDeclaringClass();
        Field[] fields = declaringClass.getFields();
        System.out.println(Arrays.toString(fields));
        EnumIsmY01[] values1 = EnumIsmY01.values();
        System.out.println(Arrays.toString(values1));
        String s = EnumIsmY01.A.toString();
        System.out.println(s);
    }

    public void method16(){

        EnumIsMy one = EnumIsMy.ONE;
        String aa = EnumIsMy.aa;
        System.out.println(aa);
        int ordinal = one.ordinal();
        System.out.println(ordinal);
        EnumIsMy[] values = EnumIsMy.values();
        EnumIsMy enumIsMy = EnumIsMy.valueOf(EnumIsMy.ONE.name());
        System.out.println(enumIsMy);
        System.out.println(Arrays.toString(values));
        System.out.println(one.name());
    }

    public void method15(){

        Singlon instance1 = Singlon.getInstance();
        Singlon instance2 = Singlon.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }

    public void method14() throws ClassNotFoundException, NoSuchMethodException {

        Class<AnnotationEntity> c = AnnotationEntity.class;
        AnnotationMy typeAn = c.getAnnotation(AnnotationMy.class);
        String name = typeAn.name();
        System.out.println("type = "+name);
        Class<? extends Number> typeCl = typeAn.classI();
        System.out.println(typeCl);
        String[] names = typeAn.names();
        System.out.println(Arrays.toString(names));

        Method method01 = c.getMethod("method01");
        AnnotationMy annotation = method01.getAnnotation(AnnotationMy.class);
        System.out.println(annotation.classI());
        System.out.println(annotation.number());;
        System.out.println(Arrays.toString(annotation.names()));
        System.out.println(annotation.name());

        /*Annotation[] annotations = c.getAnnotations();
        System.out.println(Arrays.toString(annotations));*/

    }

    public void method13() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        List<String> list = new ArrayList<>();
        list.add("123");
        Class<? extends List> aClass = list.getClass();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(list, 123);
        add.invoke(list,456);
        System.out.println(list);

    }

    public void method12() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        ReflectEntity r = new ReflectEntity();
        Class<? extends ReflectEntity> aClass = r.getClass();
        ReflectEntity reflectEntity = aClass.newInstance();
        Method method = aClass.getMethod("method");
        Object invoke = method.invoke(reflectEntity);
       /* Method methodPrivate = aClass.getDeclaredMethod("methodPrivate", String.class, Integer.class);
        methodPrivate.setAccessible(true);
        Object invoke = methodPrivate.invoke(r, "123", 123);
        System.out.println(invoke);*/
    }

    public void method11() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<ReflectEntity> reflectEntityClass = ReflectEntity.class;
        Constructor<ReflectEntity> declaredConstructor = reflectEntityClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        ReflectEntity reflectEntity = declaredConstructor.newInstance("112");

        /*Constructor<ReflectEntity> constructor = reflectEntityClass.getConstructor(String.class, String.class);
        ReflectEntity reflectEntity = constructor.newInstance("呀吼", "123");
        String name = reflectEntity.getName();
        String desc = reflectEntity.desc;
        System.out.println(name);
        System.out.println(desc);*/

        /*Constructor<?>[] declaredConstructors = reflectEntityClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            declaredConstructor.setAccessible(true);
            System.out.println(declaredConstructor);
        }*/
    }

    public void method10() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {

        Class<?> aClass = Class.forName("com.cui.cn.java8.base.ReflectEntity");
        Object o1 = aClass.newInstance();
        /*Field name = aClass.getField("desc");
        Object o = name.get(o1);
        System.out.println(o);
        name.set(o1,"123");
        System.out.println(name);
        // String name1 = name.getName();
        // System.out.println(name1);
        //Method[] declaredMethods = aClass.getDeclaredMethods();
        //System.out.println(Arrays.toString(declaredMethods));
        Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));*/

        Field name1 = aClass.getDeclaredField("name");
        name1.setAccessible(true);
        String name2 = name1.getName();
        name1.set(o1,"666");
        Object o = name1.get(o1);
        System.out.println(name2);
        System.out.println(o);

    }

    public void method09() throws ClassNotFoundException {

        Class<?> aClass = Class.forName("com.cui.cn.java8.base.ReflectEntity");
        System.out.println(aClass);

        Class<ReflectEntity> reflectEntityClass = ReflectEntity.class;
        System.out.println(reflectEntityClass);


        ReflectEntity reflectEntity = new ReflectEntity();
        Class<? extends ReflectEntity> aClass1 = reflectEntity.getClass();
        System.out.println(aClass1);
    }

    public void method08(){

        A2 a2 = new A2();
        boolean b = a2 instanceof A;
        A a = a2;
        a.f1();
        System.out.println(b);

    }

    public void method07(){

        AbstroctSon01 abstroctSon01 = new AbstroctSon01();
        AbstroctSon01.staticMethod();

    }

    public void method06(){

        Father01 f1 = new FatherIsSon01();
        f1.method01();
        //f1.method02();
        /*String fatherAttr = f1.fatherAttr;
        System.out.println(fatherAttr);
        FatherIsSon01.method04();*/
    }

    public void method05(){

        ThisTest thisTest1 = new ThisTest();
        ThisTest thisTest2 = new ThisTest();
        ThisTest thisTest3 = new ThisTest();
        thisTest1.method01(1);
        thisTest2.method01(1);
        thisTest3.method01(1);
    }

    public void method04(){

        Student s1 = new Student("老三",23);
        int number = s1.getNumber();
        System.out.println(number);
        s1.setNumber(987);
        int number1 = s1.getNumber();
        System.out.println(number1);

    }

    public void method03(){

        Student s1 = new Student();
        s1.setId(11);
        Student s2 = new Student();
        s2.setId(11);
        boolean equals = s1.equals(s2);
        System.out.println(equals);
    }

    public void method02(){

        Student s = new Student();
        if(s instanceof  Student){
            System.out.println("yes");
        }
    }

    public void method01() {

        int a = 1;
        a =  a++ + ++a;
        System.out.println(a); // 4
    }
}