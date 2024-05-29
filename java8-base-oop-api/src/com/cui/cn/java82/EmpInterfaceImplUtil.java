package com.cui.cn.java82;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 86183 - cuizhihao
 * @create 2024-05-09-22:44
 */
public class EmpInterfaceImplUtil {

    public static List<Emp82> getNewEmp82(List<Emp82> list,EmpInterface<Emp82> empInterface){

        List<Emp82> list82 = new ArrayList<>();
        if(list != null && list.size()>0){
            for (Emp82 emp82 : list) {
                if(empInterface.testAll(emp82)){
                    list82.add(emp82);
                }
            }
        }
        return list82;
    }
}
