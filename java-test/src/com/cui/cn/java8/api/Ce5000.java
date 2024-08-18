package com.cui.cn.java8.api;

import java.math.BigDecimal;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-05-22:13
 */
public class Ce5000 implements CeInter<Emp>{

    @Override
    public Boolean test(Emp emp) {
        if(emp.getSla().compareTo(new BigDecimal("5000")) >= 0){
            return true;
        }
        return false;
    }
}
