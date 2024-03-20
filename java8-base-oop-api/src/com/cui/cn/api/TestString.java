package com.cui.cn.api;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestString {

    public static void main(String[] args) {

        TestString t = new TestString();
        t.method10();

//        t.method04();
//        t.method03();
//        t.method02();
//        t.method01();

    }

    public void method10(){

        StringBuffer buffer = new StringBuffer();
        buffer.append(123);
        StringBuilder builder = new StringBuilder();
        builder.append("adsef");
        System.out.println(buffer);
        System.out.println(builder);

    }

    public void method09(){

        String str = "sa7da90fda8ifa7fa09-=*9";
        //String str = "afdas=-";
        String regx = "[^0-9]";
        /*String replace = str.replaceAll(regx, "");
        System.out.println(replace);*/
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(str);
        String s = matcher.replaceAll("");
        System.out.println(s);
        boolean matches = matcher.matches();
        System.out.println(matches);

    }

    // 正则表达式
    public void method08(){

        String str = "sa7da90fda8ifa7fa09";
        String regex = "[^0-9]";
        String[] split = str.split(regex);
        System.out.println(Arrays.toString(split));
        String w = str.replaceAll(regex, "W");
        System.out.println(w);

        /*String str = "hello";
        String regx = "[a-z]{5}";
        boolean matches = str.matches(regx);
        System.out.println(matches);*/

    }

    public void method07(){

        Object i = null;
        String value1 = String.valueOf(i); // 将null直接转换成null字符串的形式，不会有空指针异常
        String s = i.toString(); // 在处理null时会报 NullPointerException，空指针异常
        String i1 = (String) i; // 可以强制转型为null字符串
        System.out.println(i1);

        Integer in = 100;
        String s1 = String.valueOf(in); // 使用valueOf对数据类型进行转换
        String s2 = in.toString(); // 封装类型提供了toString方法
        // (String)in; // 错误，封装类型无法强制类型转换

        int a = 10;
        String value = String.valueOf(a); // 将基本数据类型转换为String类型
        // (String)a; // 报错，基本数据类型不支持强制类型转换
        // a.toString(); // 基本数据类型没有toString方法

    }

    public void method06(){

        String str12 = "null";
        boolean empty = str12.isEmpty();
        System.out.println(empty);

        String str13 = "HELLO";
        boolean b = str12.equalsIgnoreCase(str13);
        System.out.println();
        String str1 = "12345689";
        String str2 = "1234568";
        System.out.println(str1.equals(str2));
        System.out.println(str1.compareTo(str2));
    }

    public void method05(){

        String str = "hello321hello_=*90-";
        boolean contains = str.contains("99");
        System.out.println(contains);
//        String h = str.replace("h", "90");
//        String s = str.replaceAll("[^0-9]", "");
//        System.out.println(s);

    }

    public void method04(){

        String str = "hello";
        String substring = str.substring(2);
        System.out.println(substring);
        String substring1 = str.substring(2, 6);
        System.out.println(substring1);
    }

    // 子串出现的次数
    public void method03(){
        String str = "headheadheadwo";
        int count = 0; // 出现的次数
        String str_son = "ad"; // 子串
        int index = 0;
        int fromindex = 0; // 起始位置
        while((index = str.indexOf(str_son,fromindex)) != -1){
            count ++;
            fromindex=index + 1;
        }
        System.out.println(count);
    }

    public void method02(){

        String str = "123456";
        int a = 10;
        int [] arr = {1,2,3,4,5};
        StringBuffer sb = new StringBuffer();
        sb.append(123);
        this.method02_1(str,a,arr,sb);
        System.out.println("--------------------");
        System.out.println(str);
        System.out.println(a);
        System.out.println(Arrays.toString(arr));
        System.out.println(sb);
    }

    private void method02_1(String str,int a,int [] arr,StringBuffer sb){

        str = "666";
        a = 20;
        arr[0] = 789;
        sb.append("aa");
        System.out.println(str);
        System.out.println(a);
        System.out.println(Arrays.toString(arr));
        System.out.println(sb);

    }

    /*
    常用api
     */
    public void method01(){

        short a = Short.MIN_VALUE;
        System.out.println(a);
        String str1 = "321kklljjhh";
        int i = str1.indexOf('1');
        int l = str1.indexOf('l');
        System.out.println(l);
        System.out.println(i);
        System.out.println(str1.length());

    }
}
