package com.cui.cn.java8;

import java.util.Optional;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-24-3:45
 */
public class FlatMapTest {

    private String name;

    private String id;

    // Optional容器中的泛型，有时也是实体类；如：Optional<Student>
    private Optional<String> desc;

    public FlatMapTest() {
    }

    public FlatMapTest(String name, String id, Optional<String> desc) {
        this.name = name;
        this.id = id;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Optional<String> getDesc() {
        return desc;
    }

    public void setDesc(Optional<String> desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "FlatMapTest{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", desc=" + desc +
                '}';
    }
}
