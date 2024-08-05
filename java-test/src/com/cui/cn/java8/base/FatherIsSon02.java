package com.cui.cn.java8.base;

/**
 * @author 86183 - cuizhihao
 * @create 2024-07-17-17:15
 */
public class FatherIsSon02 extends Father02{

    public static void main(String[] args) {

        FatherIsSon02 fis = new FatherIsSon02();
        fis.me();
        fis.method01();
    }



    public void me(){
        this.method01();
    }

}
