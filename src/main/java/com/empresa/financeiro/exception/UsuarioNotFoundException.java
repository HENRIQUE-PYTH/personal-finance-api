package com.empresa.financeiro.exception;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException (String msg){
        super(msg);
    }
}
