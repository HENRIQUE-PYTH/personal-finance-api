package com.empresa.financeiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BusinessException extends RuntimeException{
    public BusinessException (String msg){
        super(msg);
    }
}
