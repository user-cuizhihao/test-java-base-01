package com.cui.cn.oop;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-18-2:25
 */
public class StudentBean {

    private Integer uuid;

    private String name;

    private Date dateTime;

    private BigDecimal money;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentBean that = (StudentBean) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(name, that.name) && Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, dateTime);
    }
}
