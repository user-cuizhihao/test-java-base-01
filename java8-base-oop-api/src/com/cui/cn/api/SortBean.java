package com.cui.cn.api;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-22-15:20
 */
public class SortBean /*implements Comparable<SortBean>*/{

    private Integer id;

    private String name;

    private Integer age;

    private String remark;

    public SortBean(Integer id, Integer age, String name, String remark) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.remark = remark;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SortBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", remark='" + remark + '\'' +
                '}';
    }

/*@Override
    public int compareTo(SortBean o) {
        return this.id - o.id;
    }*/

}
