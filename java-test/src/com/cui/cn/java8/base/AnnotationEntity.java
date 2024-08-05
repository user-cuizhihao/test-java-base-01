package com.cui.cn.java8.base;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-03-22:05
 */
@AnnotationMy(name="type",classI = Integer.class,names = {"1","2"},ENUM_IS_MY_02_S = EnumIsMy02.B)
public class AnnotationEntity {

    @AnnotationMy(name = "status",classI = Long.class,names = "89",ENUM_IS_MY_02_S = EnumIsMy02.B)
    public static final Integer STATUS = 1;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @AnnotationMy(name = "method",classI = Double.class,names = "90",ENUM_IS_MY_02_S = EnumIsMy02.B)
    public void method01(){
        System.out.println("方法");
    }

}
