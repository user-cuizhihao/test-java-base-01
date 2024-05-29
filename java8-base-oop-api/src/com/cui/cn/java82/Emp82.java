package com.cui.cn.java82;

/**
 * @author 86183 - cuizhihao
 * @create 2024-05-09-22:13
 */

import java.math.BigDecimal;
import java.util.Objects;

public class Emp82 {

    private String name;

    private Integer age;

    private BigDecimal money;

    private Integer zhiji;

    public Emp82() {
    }

    public Emp82(BigDecimal money, Integer zhiji) {
        this.money = money;
        this.zhiji = zhiji;
    }

    public Emp82(String name, Integer age, BigDecimal money, Integer zhiji) {
        this.name = name;
        this.age = age;
        this.money = money;
        this.zhiji = zhiji;
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getZhiji() {
        return zhiji;
    }

    public void setZhiji(Integer zhiji) {
        this.zhiji = zhiji;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp82 emp = (Emp82) o;
        return Objects.equals(name, emp.name)
                && Objects.equals(age, emp.age)
                && Objects.equals(money, emp.money)
                && Objects.equals(zhiji, emp.zhiji);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, money, zhiji);
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", zhiji=" + zhiji +
                '}';
    }
}

