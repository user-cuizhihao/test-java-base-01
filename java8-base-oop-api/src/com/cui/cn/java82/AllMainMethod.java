package com.cui.cn.java82;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 86183 - cuizhihao
 * @create 2024-05-09-22:17
 */
public class AllMainMethod {

    public List<Emp82> listEmp() {
        List<Emp82> list = new ArrayList<>();
        list.add(new Emp82("张三", 21, new BigDecimal(3500), 4));
        list.add(new Emp82("李四", 18, new BigDecimal(3000), 4));
        list.add(new Emp82("王五", 54, new BigDecimal(10000), 2));
        list.add(new Emp82("赵六", 35, new BigDecimal(5000), 3));
        list.add(new Emp82("田七", 44, new BigDecimal(7000), 3));
        list.add(new Emp82("王八", 24, new BigDecimal(7000), 3));
        list.add(new Emp82("王1", 25, new BigDecimal(71000), 1));
        list.add(new Emp82("王2", 26, new BigDecimal(71000), 1));
        list.add(new Emp82("王3", 24, new BigDecimal(7000), 3));
        return list;
    }

    public static void main(String[] args) {

        AllMainMethod allMainMethod = new AllMainMethod();
        allMainMethod.method06();
        
    }

    public void method06(){

        List<Emp82> emp82s = listEmp();
        Iterator<Emp82> iterator = emp82s.iterator();
        while (iterator.hasNext()){
            Emp82 emp = iterator.next();
            BigDecimal money = emp.getMoney();
            if(money.compareTo(new BigDecimal("5000"))>=0){
                System.out.println(emp);
            }

        }

    }

    /**
     * 获取大于都等于35岁以上的员工信息
     */
    public void method05(){

        List<Emp82> emp82s = listEmp();
        for (int i = 0; i < emp82s.size(); i++) {
            Emp82 emp82 = emp82s.get(i);
            if(emp82.getAge().compareTo(35)>=0){
                System.out.println(emp82);
            }
        }
        System.out.println("=========");
        for (Emp82 emp82 : emp82s) {
            Integer age = emp82.getAge();
            if(age.compareTo(35)>=0){
                System.out.println(emp82);
            }
        }

    }

    public void method04(){

        List<Emp82> emp82s = listEmp();
        Iterator<Emp82> iterator = emp82s.iterator();
        while (iterator.hasNext()){
            Emp82 next = iterator.next();
            emp82s.remove(next);
        }
        System.out.println(emp82s);
        /*for (int i = 0; i < emp82s.size(); i++) {
            Emp82 emp82 = emp82s.get(i);
            if(emp82.getMoney().compareTo(new BigDecimal("7000")) == 0){
                emp82s.remove(i);
            }
        }*/
    }

    public void method03(){

        List<Emp82> emp82s = listEmp();
        /*Collections.sort(emp82s, (e1, e2)->e1.getAge().compareTo(e2.getAge()));
        emp82s.sort( (e1,e2)->e1.getAge().compareTo(e2.getAge()));
        emp82s.stream().sorted( (e1,e2)->e1.getAge().compareTo(e2.getAge()));*/
        List<Emp82> collect = emp82s
                .stream()
                .sorted(Comparator.comparing((Function<Emp82, BigDecimal>) emp82 -> emp82.getMoney())
                        .thenComparing(Comparator.comparing(Emp82::getAge).reversed()))
                .collect(Collectors.toList());
        for (Emp82 emp82 : collect) {
            System.out.println(emp82);
        }

    }

    public void method02(){

        List<Emp82> emp82s = listEmp();

        List<Emp82> newEmp82 = EmpInterfaceImplUtil.getNewEmp82(emp82s,
                emp82->{
                    if (emp82.getAge().compareTo(22) > 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
                /*new EmpInterface<Emp82>() {
                    @Override
                    public Boolean testAll(Emp82 emp82) {
                        if (emp82.getAge().compareTo(22) > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }*/);

        System.out.println(newEmp82);

    }

    public void method01(){

        List<Emp82> emp82s = listEmp();
        /*List<Emp82> listNew = new ArrayList<>();
        for (Emp82 emp82 : emp82s) {
            if(emp82.getAge().compareTo(35)>0){
                listNew.add(emp82);
            }
        }*/

        //List<Emp82> listNew = emp82s.stream().filter(e -> e.getAge().compareTo(35) > 0).collect(Collectors.toList());

        /*List<Emp82> collect = emp82s.stream().map(e -> {
            if (e.getAge().compareTo(35) > 0) {
                return e;
            } else {
                return null;
            }
        }).collect(Collectors.toList());*/

        EmpInterface<Emp82> empInterface = new EmpInterfaceImpl02();
        List<Emp82> newEmp82 = EmpInterfaceImplUtil.getNewEmp82(emp82s, empInterface);

        System.out.println(newEmp82);
    }

}
