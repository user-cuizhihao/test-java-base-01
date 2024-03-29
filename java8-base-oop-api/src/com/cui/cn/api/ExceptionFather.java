package com.cui.cn.api;

import java.io.FileNotFoundException;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-29-8:56
 */
public class ExceptionFather {

    // 非检测异常不需要抛出
    public void method01(){

        throw new NullPointerException("空指针异常");
    }

    // 可检测异常由编译器抛出
    public void method02() throws FileNotFoundException {

        throw new FileNotFoundException("文件找不到");

    }

}
