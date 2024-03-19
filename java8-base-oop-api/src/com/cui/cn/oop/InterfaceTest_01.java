package com.cui.cn.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-19-12:25
 */
public class InterfaceTest_01 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(4);
        list.add(5);
        list.add(8);
        InterfaceTest_01 it1 = new InterfaceTest_01();
        it1.sortedList(new InterfaceBean_02() {
            @Override
            public List<Integer> methodAbs02(List<Integer> list) {
                return list.stream().sorted().collect(Collectors.toList());
            }
        },list);
    }

    // 对List集合进行排序
    public void sortedList(InterfaceBean_02 interfaceBean_02, List<Integer> list){
        System.out.println(list);
        System.out.println(interfaceBean_02.methodAbs02(list));
    }


}
