package com.cui.cn.api;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-29-7:51
 */
public class ExceptionTest {

    public static void main(String[] args) throws Exception {

        ExceptionTest et = new ExceptionTest();

        try {
            et.method02();
        }catch (ExceptionIsMy eim){
            throw new Exception(eim);
        }


        /*ExceptionFather ef = new ExceptionSon();
        ef.method01();*/

    }

    public void method02(){

        String str = null;
        if(str == null){

            throw new ExceptionIsMy("str 为 null",new RuntimeException("666"));

        }

    }

    public void method01(){

        try {
            System.out.println("报错前12");
            int a = 1/0;
            //System.out.println("报错后");
        }catch ( ArithmeticException e){
            e.printStackTrace();
        }finally {
            System.out.println("总是执行");
        }

        // 异常捕捉后执行的代码
        System.out.println("try catch 后");

    }


}

