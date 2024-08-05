package com.cui.cn.java8.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class SortedObject implements Serializable {

    private static final long serialVersionUID = 5052296998194450162L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SortedObject that = (SortedObject) o;
        return Objects.equals(name, that.name) && Objects.equals(age, that.age) && Objects.equals(number, that.number) && Objects.equals(money, that.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, number, money);
    }
}