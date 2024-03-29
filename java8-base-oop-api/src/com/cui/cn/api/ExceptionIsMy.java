package com.cui.cn.api;

import java.io.Serializable;

/**
 * @author 86183 - cuizhihao
 * @create 2024-03-29-11:33
 */
public class ExceptionIsMy extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 3993732170825664529L;

    /**
     * 异常信息
     */
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExceptionIsMy(String message){

        this.message = message;

    }

    public ExceptionIsMy(String message,Exception e){

        this.message = message;
        e.printStackTrace();

    }

}
