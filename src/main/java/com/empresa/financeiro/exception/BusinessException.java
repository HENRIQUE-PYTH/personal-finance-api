package com.empresa.financeiro.exception;

public class BusinessException extends RuntimeException{
    public BusinessException (String msg){
        super(msg);
    }
}
