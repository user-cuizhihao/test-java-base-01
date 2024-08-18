package com.cui.cn.java8.api;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-05-21:52
 */
public class Emp {

    /**
     * 员工名称
     */
    private String name;

    /**
     * 员工年龄
     */
    private Integer age;

    /**
     * 员工工资
     */
    private BigDecimal sla;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return Objects.equals(age, emp.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    public Emp() {

    }

    public Emp(String name, Integer age, BigDecimal sla) {
        this.name = name;
        this.age = age;
        this.sla = sla;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getSla() {
        return sla;
    }

    public void setSla(BigDecimal sla) {
        this.sla = sla;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sla=" + sla +
                '}';
    }

    // 静态方法，消费型
    public static void method(String s){
        System.out.println("静态方法"+s);
    }

    // 消费型
    public void consumerM(String s){
        System.out.println(s);
    }

    // 断定型
    public Boolean predicateM(String s){
        if(s != null && s.length()>0){
            return true;
        }else{
            return false;
        }
    }

    // 函数式
    public Integer functionM(String s){
        return Integer.parseInt(s);
    }

    // 供给型
    public Integer supplierM(){
        return 100;
    }

    // 将String类型转换成Integer类型
    /*public Integer toInteger(){

    }*/
}
