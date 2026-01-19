package com.empresa.financeiro.exception;

public class SameEmailException extends RuntimeException{
    public SameEmailException(String msg){
        super(msg);
    }

}
