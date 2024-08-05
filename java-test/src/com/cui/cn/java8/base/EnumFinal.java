package com.cui.cn.java8.base;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-05-20:09
 */
public enum EnumFinal {

    A(1,"a1"),
    B(2,"b2"),
    C(3,"c3");

    private Integer i;
    private String j;

    EnumFinal(Integer i,String j){
        this.i = i;
        this.j = j;
    }

    public Integer i(){
        return i;
    }

    public String j(){
        return j;
    }

    // 通过i返回j
    public static String setIGetJ(Integer i){
        EnumFinal[] values = EnumFinal.values();
        for (EnumFinal value : values) {
            if(value.i().equals(i)){
                return value.j();
            }
        }
        return null;
    }

    public static Integer setJGetI(String j){
        EnumFinal [] values = EnumFinal.values();
        for (EnumFinal value : values) {
            if(value.j().equals(j)){
                return value.i();
            }
        }
        return null;
    }

    public static EnumFinal setIGetEnum(Integer i){
        EnumFinal[] values = EnumFinal.values();
        for (EnumFinal value : values) {
            if(value.i().equals(i)){
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "EnumFinal{" +
                "i=" + i +
                ", j='" + j + '\'' +
                '}';
    }
}
