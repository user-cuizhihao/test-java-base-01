package com.cui.cn.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 86183 - cuizhihao
 * @create 2024-04-12-13:35
 */
public class CelveUtil {

    public static List<Emp> getData(List<Emp> list,CeLve<Emp> ceLve){

        List<Emp> listNew = new ArrayList<>();
        for (Emp emp : list) {
            if (ceLve.getDataByData(emp)) {
                listNew.add(emp);
            }
        }
        return listNew;
    }

}
