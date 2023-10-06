package com.ingesoft.logic;

public class ExcepcionUsuarios extends Exception{
    public ExcepcionUsuarios(){
        super();
    }

    public ExcepcionUsuarios(String message){
        super(message);
    }

    public ExcepcionUsuarios(String message, Throwable cause){
        super(message, cause);
    }
}
