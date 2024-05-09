package com.cui.cn.java8;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-12-12:35
 */
public class Emp {

    private String name;

    private Integer age;

    private BigDecimal money;

    private Integer zhiji;

    public Emp() {
    }

    public Emp(BigDecimal money, Integer zhiji) {
        this.money = money;
        this.zhiji = zhiji;
    }

    public Emp(String name, Integer age, BigDecimal money, Integer zhiji) {
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
        Emp emp = (Emp) o;
        return Objects.equals(money, emp.money) && Objects.equals(zhiji, emp.zhiji);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, zhiji);
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
