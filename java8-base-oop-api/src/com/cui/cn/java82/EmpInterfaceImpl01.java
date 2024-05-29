package com.cui.cn.java82;

/**
 * @author 86183 - cuizhihao
 * @create 2024-05-09-22:40
 */
public class EmpInterfaceImpl01 implements EmpInterface<Emp82> {

    @Override
    public Boolean testAll(Emp82 emp) {
        if(emp.getAge().compareTo(35)>0){
            return true;
        }else{
            return false;
        }
    }
}
