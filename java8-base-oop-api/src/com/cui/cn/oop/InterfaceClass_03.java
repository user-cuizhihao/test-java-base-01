package com.cui.cn.oop;

import java.util.List;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-29-8:18
 */
public class InterfaceClass_03 implements InterfaceBean_03{

    @Override
    public void methodAbs01() {

    }

    @Override
    public List<Integer> methodAbs02(List<Integer> list) {
        return null;
    }

    @Override
    public void methodDe() {
        InterfaceBean_03.super.methodDe();
    }
}
