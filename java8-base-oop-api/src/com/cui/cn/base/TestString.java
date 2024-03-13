package com.cui.cn.base;

public class TestString {

    public static void main(String[] args) {

        TestString t1 = new TestString();
        t1.method05();
//        t1.method04();
//        t1.method03();
        /*int i = t1.method001();
        int i1 = t1.method002();
        System.out.println(i1);
        System.out.println(i);*/
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

