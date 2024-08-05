package com.cui.cn.java8.base;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author 86183 - cuizhihao
 * @create 2024-07-03-19:04
 */
public class Student implements Comparator<Student> {

    private String name;

    private int number;

    private Integer id;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", id=" + id +
                '}';
    }

    public Student(String name, Integer id) {
        this.number = 123456;
        this.name = name;
        this.id = id;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.number - o2.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Student() {
    }

    public Student(String name, int number, Integer id) {
        this.name = name;
        this.number = number;
        this.id = id;
    }

    public Student(int number) {
        this.number = number;
    }

    public Student(Integer id) {
        this.id = id;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
