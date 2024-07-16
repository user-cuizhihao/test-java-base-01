package com.cui.cn.java8.base;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author 86183 - cuizhihao
 * @create 2024-07-01-10:05
 */
public class Test01 {

    public static void main(String[] args) {

        Test01 t = new Test01();
        t.method28();
    }

    public void method28(){

        Integer[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a)); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        int i = Arrays.binarySearch(a, 6);
        System.out.println(i); // 下标为6

    }

    public void method27(){

        Integer [] a = {1,321,54,345,23445,3,4536,476,2534,123};
        Arrays.sort(a, 0,6,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(Arrays.toString(a));

        // Arrays.sort(a,0,3);
        // System.out.println(Arrays.toString(a));
        /*System.out.println(a.length);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(a.length);*/

    }

    public void method26(){

        int target = 9;
        int [] arr1 = {1,2,3,4,5,6,7,8,9};
        // 定义目标值索引的初始值
        int index = 0;
        // 定义最大索引
        int max = arr1.length - 1;
        // 定义最小索引
        int min = 0;
        while(min <= max){
            int zj = (min + max)/2;
            if(arr1[zj] > target){
                max = zj-1;
            }else if(arr1[zj]<target){
                min = zj+1;
            }else{
                index = zj;
                break;
            }
        }
        System.out.println(index);

    }
    public void method25(){

        int target = 10;
        int [] arr1 = {1,2,3,4,5,6,7,8,9};
        /*int [] arr = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if(map.containsKey(arr1[i])){
                arr[0] = map.get(arr1[i]);
                arr[1] = i;
            }
            map.put(target-arr1[i],i);
        }
        System.out.println(Arrays.toString(arr));
*/
        Map<Integer,Integer> map ;
        List<Map<Integer,Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i+1; j < arr1.length; j++) {
                int temp = arr1[i] + arr1[j];
                if(temp == target){
                    map = new HashMap<>();
                    map.put(i,arr1[i]);
                    map.put(j,arr1[j]);
                    list.add(map);
                }
            }
        }
        System.out.println(list);
    }

    // 冒泡排序 和 选择排序
    public void method24(){

        int [] arr = {1,321,54,345,23445,3,4536,476,2534,123};
        // 选择排序
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 1+i; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        // 冒泡排序
        /*for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));*/
    }

    public void method23(){

        int [] arr = {1,2,3,4,5,6,7,8,9,0,2,3,4,5,6,7,1,1};
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                Integer value = map.get(arr[i]);
                map.put(arr[i],value+1);
            }else{
                map.put(arr[i],1);
            }
        }
        System.out.println(map);

    }

    public void method22(){

        int [] arr = {1,2,3};
        int[] ints = Arrays.copyOf(arr, 10);
        System.out.println(Arrays.toString(ints));

    }

    public void method21(){

        int [] a = {1,321,54,345,23445,3,4536,476,2534,123};
        int [] b = new int[20]; // 23445,3,4536,476,2534
        System.arraycopy(a,4,b,12,5);
        System.out.println(Arrays.toString(b));
    }

    public void method20(){

        for(int i = 1; i <= 2; i++){
            System.out.println(111);
        }

    }

    public void method19(){

        aa:
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            for (int i1 = 0; i1 < 20; i1++) {
                System.out.println(i1 + "  内层循环！");
                if(i1 == 2){
                    break aa;
                }
            }
        }
    }

    public void method18(){

        String str = 18>9 ? "yes":"no";
        System.out.println(str);

    }

    public void method17(){

        double d = 19.0547;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String format = decimalFormat.format(d);
        System.out.println(format);


    }

    // 使用 BigDecimal 来处理小数类型
    public void method16() {

        Double d1 = 1.099;
        Double d2 = 1.001;
        System.out.println(d1 + d2);
        BigDecimal bd1 = new BigDecimal(d1.toString());
        BigDecimal bd2 = new BigDecimal(d2.toString());
        BigDecimal add = bd1.add(bd2);
        System.out.println(add);

    }

    // 运算
    public void method04() {

        int a = 1;
        int b = a++ + ++a;
        System.out.println(b);
        System.out.println(a);
        //System.out.println(b);
        //System.out.println(b);
    }

    public void method15() {

        String s1 = new String("he") + new String("llo");
        s1.intern();
        String s2 = "hello";
        System.out.println(s1 == s2); // true

    }

    /**
     * String 字面量直接赋值测试
     */
    public void method14() {

        final String s4 = "hello";
        final String s5 = "hello";
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "he" + "llo";
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s2 == s4);
        System.out.println(s4 == s5);

    }

    public void method13() {

        String str1 = "123";
        String str2 = new String("123");
        System.out.println(str1.equals(str2));

    }

    /**
     * 在源码中搜索关键字 cache
     */
    public void method12() {

        // 查看源码可知，Byte类型的cache在-128 ~ 127之间
        Byte b1 = 127;
        Byte b2 = 127;
        System.out.println(b1 == b2); // true; 查看源码可知，Byte类型的cache在-128 ~ 127之间

        // 查看源码可知，Short类型的cache在-128 ~ 127之间
        short s1 = 127;
        Short s2 = 127;
        Short s3 = 128;
        Short s4 = 128;
        System.out.println(s1 == s2); // true
        System.out.println(s3 == s4); // false

        // 查看源码可知，Long类型的cache在-128 ~ 127之间
        Long l1 = 127l;
        Long l2 = 127l;
        Long l3 = 128l;
        Long l4 = 128l;
        System.out.println(l1 == l2); // true
        System.out.println(l3 == l4); // false
    }

    public void method11() {

        Integer i1 = 60;
        Integer i2 = 60;
        Integer i3 = new Integer(60);
        Integer i4 = new Integer(60);
        int i5 = 60;
        System.out.println(i1); // 60
        System.out.println(i3); // 60
        System.out.println(i1 == i2); // true; 因为i1和i2定义时在同一个cache中
        System.out.println(i1 == i3); // false; 因为i1引用的是cache中的数值，而i3是new的一个对象
        System.out.println(i3 == i4); // false; i3 和 i4是两个不同的对象
        System.out.println(i3 == i5); // true; i3自动拆箱成int类型和i5进行比较

    }

    public void method10() {

        String str1 = new String("123") + new String("456");
        String str2 = str1.intern();
        System.out.println(str1 == str2);

    }

    public void method09() {

        Student student = new Student(10);
        String name = student.name;
        Integer number = student.number;
        System.out.println(number);
        System.out.println(name);

    }

    public void method08() {

        Class<Test02> test02Class = Test02.class;
        ClassLoader classLoader = test02Class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        System.out.println(parent.getParent());
    }

    public void method07() {

        //类是模板；实例化是对象的具体表现
        Student stu1 = new Student(1);
        Student stu2 = new Student(2);
        Student stu3 = new Student(3);
        System.out.println(stu1.hashCode()); // 357642
        System.out.println(stu2.hashCode()); // 357642
        System.out.println(stu3.hashCode()); // 357642

        Class<? extends Student> c1 = stu1.getClass();
        Class<? extends Student> c2 = stu2.getClass();
        Class<? extends Student> c3 = stu3.getClass();
        System.out.println(c1.hashCode()); // 1558600329
        System.out.println(c2.hashCode()); // 1558600329
        System.out.println(c3.hashCode()); // 1558600329
    }

    public void method6() {

        String str1 = new String("123");
        String str2 = new String("123");
        System.out.println(str1 == str2); // false
        System.out.println(str1.intern() == str2.intern()); // true
        String str3 = new String("456").intern();
        String str4 = new String("456").intern();
        System.out.println(str3 == str4); // true
    }

    public void method05_8() {
        //使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        //10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++) + "---" + Long.MAX_VALUE);
        }
    }

    public void method05_7() {

        List<String> stringList = new ArrayList<>();
        int i = 1;
        while (true) {
            stringList.add(String.valueOf(i));
        }
    }

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop(); // 每一个任务都无法执行完
                }
            });
            thread.start();
        }
    }

    // 多线程引起的内存溢出
    public void method05_5() {
        while (true) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(Integer.MAX_VALUE);
                    } catch (Exception e) {
                    }
                }
            }.start();
        }
    }

    // 本地直接内存的内存溢出
    public void method05_4() {

        System.out.println("maxDirectMemory is:" + sun.misc.VM.maxDirectMemory() / 1024 / 1024 + "MB");

        //ByteBuffer buffer = ByteBuffer.allocate(6*1024*1024);
        ByteBuffer buffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }

    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }

    /**
     * JVM 参数： -Xmx10m -XX:+PrintGCDetails
     */
    public void method05_3() {
        Map m = new HashMap();
        while (true) {
            for (int i = 0; i < 1000; i++) {
                if (!m.containsKey(new Key(i))) {
                    m.put(new Key(i), "Number:" + i);
                }
            }
            System.out.println("m.size()=" + m.size());
        }
    }

    // 创建一个死循环
    public void method05_2() {

        List list = new ArrayList();
        while (true) {
            list.add(new Test01());
        }
    }

    // 直接创建一个最大的数组
    public void method05_1() {

        /*int size = 2 * 1024 * 1024;
        int[] i = new int[size];*/
        List list = new ArrayList(Integer.MAX_VALUE);

    }

    // 浮点类型的有效位位数
    public void method03() {

        float f = 10.12345478f;
        System.out.println(f);

        double d = 10.12345678987654567867;
        System.out.println(d);

    }

    // 格式化浮点类型的小数
    public void method02() {

        double a = 12.9057;
        DecimalFormat df = new DecimalFormat("#.##");
        String format = df.format(a);
        System.out.println(format);

    }

    // 对小数进行运算
    public void method01() {

        double a = 1.11;
        double b = 1.219;
        System.out.println(b - a);
        BigDecimal bg1 = new BigDecimal(Double.toString(a));
        BigDecimal bg2 = new BigDecimal(Double.toString(b));
        BigDecimal subtract = bg2.subtract(bg1);
        System.out.println(subtract);
    }
}
