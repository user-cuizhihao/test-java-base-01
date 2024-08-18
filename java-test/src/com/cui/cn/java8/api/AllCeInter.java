package com.cui.cn.java8.api;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-05-22:20
 */
public class AllCeInter {

    public static List<Emp> pan(CeInter<Emp> ceInter,List<Emp> l){

        List<Emp> list = new ArrayList<>();
        for (Emp emp : l) {
            if(ceInter.test(emp)){
                list.add(emp);
            }
        }
        return list;
    }

}
