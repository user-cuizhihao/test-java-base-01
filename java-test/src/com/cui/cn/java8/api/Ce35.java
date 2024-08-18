package com.cui.cn.java8.api;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-05-22:12
 */
public class Ce35 implements CeInter<Emp>{

    @Override
    public Boolean test(Emp e) {
        if(e.getAge().compareTo(35) >= 0){
            return true;
        }
        return false;
    }
}
