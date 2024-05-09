package com.cui.cn.java8;

import java.math.BigDecimal;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-12-13:27
 * 大于等于5000
 */
public class SlaBigEq5000 implements CeLve<Emp> {

    @Override
    public Boolean getDataByData(Emp emp) {

        if (emp.getMoney().compareTo(new BigDecimal(5000))>=0) {
            return true;
        }
        return false;
    }
}
