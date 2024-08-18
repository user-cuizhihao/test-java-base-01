package com.cui.cn.java8.api;

import java.math.BigDecimal;

public class SortedObject {

    private String name;

    private Integer age;

    private Integer number;

    private BigDecimal money;

    public SortedObject() {
    }

    public SortedObject(String name, Integer age, Integer number, BigDecimal money) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.money = money;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "SortedObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                ", money=" + money +
                '}';
    }
}