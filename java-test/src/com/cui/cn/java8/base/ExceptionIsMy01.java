package com.cui.cn.java8.base;

/**
 * @author 86183 - cuizhihao
 * @create 2024-08-03-16:51
 */
public class ExceptionIsMy01 extends RuntimeException{

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExceptionIsMy01() {
    }

    public ExceptionIsMy01(String message) {
        this.message = message;
    }

    public ExceptionIsMy01(String message, Exception e) {
        this.message = message;
        e.printStackTrace();
    }
}
