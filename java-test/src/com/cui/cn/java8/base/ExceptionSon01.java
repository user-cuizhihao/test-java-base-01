package com.cui.cn.java8.base;

import java.io.IOException;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-03-15:19
 */
public class ExceptionSon01 extends ExceptionFather01{

    @Override
    public void method01(){

        //throw new NullPointerException("");
        super.method01();
    }

    @Override
    public void method02() throws IOException, ClassNotFoundException {
        super.method02();
    }
}
