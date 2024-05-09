package com.cui.cn.java8;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-12-13:22
 * 大于35
 */
public class AgeBig35 implements CeLve<Emp>{

    @Override
    public Boolean getDataByData(Emp emp) {

        if (emp.getAge()>35) {
            return true;
        }
        return false;
    }
}
