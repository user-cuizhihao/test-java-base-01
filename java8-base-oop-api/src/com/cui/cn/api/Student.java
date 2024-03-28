package com.cui.cn.api;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-28-11:22
 */
public class Student implements Serializable/*, Comparable<Student>*/ {

    private static final long serialVersionUID = -3768109501014099515L;

    private String id;

    private String name;

    private Integer number;

    private String desc;

    /*@Override
    public int compareTo(Student o) {
        return this.number - o.getNumber();
    }*/

    public Student() {
    }

    public Student(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public Student(String id, String name, Integer number, String desc) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(number, student.number) && Objects.equals(desc, student.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, number, desc);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", desc='" + desc + '\'' +
                '}';
    }
}
