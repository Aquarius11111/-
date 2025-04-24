package com.example.back.exception;

public class ServiceException extends RuntimeException{

    private String code;

    public String getCode() {
        return code;
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String code, String message){
        super(message); // 这一行要放在最前面，基础知识
        this.code = code;
    }
}
