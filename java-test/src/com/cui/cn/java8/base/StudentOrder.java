package com.cui.cn.java8.base;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-01-10:18
 */
public class StudentOrder implements Comparable<StudentOrder>{

    private String name;

    private Integer number;

    public StudentOrder() {
    }

    public StudentOrder(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "StudentOrder{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public int compareTo(StudentOrder o) {
        return this.number - o.number;
    }
}
