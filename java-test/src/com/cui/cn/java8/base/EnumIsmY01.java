package com.cui.cn.java8.base;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-05-15:21
 */
public enum EnumIsmY01 {
    
    A(1,"one"),B(2,"two");

    EnumIsmY01(Integer number, String str){
        this.number = number;
        this.str = str;
    }

    private Integer number;
    private String str;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "EnumIsmY01{" +
                "number=" + number +
                ", str='" + str + '\'' +
                '}';
    }
}
