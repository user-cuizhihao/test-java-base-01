package com.cui.cn.java8.base;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-03-16:30
 */
public class ExceptionIsMy extends Exception{

    // 异常描述信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExceptionIsMy(){

    }

    public ExceptionIsMy(String message){
        this.message = message;
    }

    public ExceptionIsMy(String message,Exception e){
        this.message = message;
        e.printStackTrace();
    }

}
