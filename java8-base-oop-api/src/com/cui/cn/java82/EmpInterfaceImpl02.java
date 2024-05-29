package com.cui.cn.java82;

import java.math.BigDecimal;

/**
 * @author 86183 - cuizhihao
 * @create 2024-05-09-22:42
 */
public class EmpInterfaceImpl02 implements EmpInterface<Emp82> {
    @Override
    public Boolean testAll(Emp82 emp) {

        if (emp.getMoney().compareTo(new BigDecimal("5000")) > 0)
            return true;
        else return false;
    }
}
