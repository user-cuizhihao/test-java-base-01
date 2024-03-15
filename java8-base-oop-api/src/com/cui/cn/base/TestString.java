package com.cui.cn.base;

import java.util.*;

public class TestString {

    public static void main(String[] args) {

        TestString t1 = new TestString();
        t1.method09();
//        t1.method08();
//        t1.method06();
//        t1.method05();
//        t1.method04();
//        t1.method03();
        /*int i = t1.method001();
        int i1 = t1.method002();
        System.out.println(i1);
        System.out.println(i);*/
    }

    // 数组算法
    public void method09(){

        Integer[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        Integer[] b = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        boolean equals = Arrays.equals(a, b);
        System.out.println(equals);


        //目标数组
        /*int target = 9;
        int [] arr1 = {1,2,3,4,5,6,7,8,9};
        int index = 0;
        int maxIndex = arr1.length-1;
        int minIndex = 0;
        while(minIndex <= maxIndex){
            // 中间值
            int zj = (minIndex + maxIndex) / 2;
            if(arr1[zj] > target){
                maxIndex = zj-1;
            }else if(arr1[zj] < target){
                minIndex = zj+1;
            }else{
                index = zj;
                break;
            }
        }
        System.out.println(index);*/

        // 计算目标数组中的两个元素和等于指定元素
        /*int target = 10;
        int [] arr1 = {1,2,3,4,5,6,7,8,9};

        int [] index = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if(map.containsKey(arr1[i])){
                index[0] = map.get(arr1[i]);
                index[1] = i;
            }
            map.put(target-arr1[i],i);
        }
        System.out.println(Arrays.toString(index));*/

        /*List<Map<Integer,Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i+1; j < arr1.length; j++) {
                if((arr1[i]+arr1[j]) == target){
                    Map<Integer,Integer> map = new HashMap<>();
                    map.put(i,arr1[i]);
                    map.put(j,arr1[j]);
                    list.add(map);
                }
            }
        }
        System.out.println(list);*/

        /*int [] arr = {1,321,54,345,23445,3,4536,476,2534,123};
        System.out.println(arr.length);
        // 选择排序
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i]; // 定义置换的值
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));*/

        // 冒泡排序
        /*for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j]; // 定义置换的值
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));*/

        // 统计数组中，每个元素出现的次数
        /*int [] arr = {1,2,3,4,5,6,7,8,9,0,2,3,4,5,6,7,1,1};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            if(map.containsKey(i)){
                Integer value = map.get(i);
                map.put(i,++value);
            }else{
                map.put(i,1);
            }
        }
        System.out.println(map);*/
    }

    // 数组的复制
    public void method08(){

        int [] a1 = new int[]{1,23412,45321,546,0,6345,342,34567,423792436,78};
        int a2[] = new int[100];
        System.out.println(a1.length); // 10
        // 方式二 数组的扩容
        int[] ints = Arrays.copyOf(a1, 5); //
        System.out.println(Arrays.toString(ints));

        // 方式一
        System.arraycopy(a1,2,a2,0,5);
        System.out.println(Arrays.toString(a2)); // 45321,546,0,6345,342,0...
    }

    /**
     * 定义数组和数组的初始化
     */
    public void method06(){

        int [] arr = {};
        String arrSrt[] = new String[10];
        boolean [] b = new boolean[10];
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrSrt));
        System.out.println(Arrays.toString(b));
    }

    public void method05(){

        String str1 = "ab";
        String str2 = "ab";
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str2);
        String str3 = new String("ab"); // 使用new
        System.out.println(str3.hashCode());
        System.out.println(str3);
        System.out.println(str3 == str2); // false st3和str2的引用是不同，所以使用==对比的结果为false）
        System.out.println(str1 == str2); // true
    }

    public void method04(){

        Integer a = null;
        String s = String.valueOf(a);
        System.out.println(s);
    }

    public void method03() {
        int a = 1;
        int c;
        switch (a) {
            case 5:
                c = ++a;
                break;
            case 1:
                c = ++a + 1;
            case 3:
                c = ++a;
            case 2:
                c = ++a + 2;
            default:
                c = 100;
        }
        System.out.println(c);

        /*Integer a = 100;
        String message = a > 100? "大于100":"不大于100";
        System.out.println(message);*/

        /*byte a = 10;
        byte b = 12;
        byte c = a+b;
        System.out.println(c);*/

        /*int a = 1;
        int b = (++a) + (++a);
        System.out.println(a); // 3
        System.out.println(b);*/

       /* long a = 10l;
        long b = 20l;
        long c = a + b;
        System.out.println(c);*/

        /*double a = 1.21;
        double b = 31.91123;
        BigDecimal a1 = new BigDecimal(String.valueOf(a));
        BigDecimal b1 = new BigDecimal(String.valueOf(b));
        BigDecimal add = a1.add(b1);
        System.out.println(add);*/

    }

    public void method02() {

        int a = 1;
        System.out.println(a);
    }

    public int method001() {
        int i = 1;
        int a = (++i) + (++i);
        System.out.println(i);
        return a;
    }

    public int method002() {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        return 0;
    }
}

