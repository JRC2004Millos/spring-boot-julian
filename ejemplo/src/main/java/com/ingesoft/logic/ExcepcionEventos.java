package com.ingesoft.logic;

public class ExcepcionEventos extends Exception {

    public ExcepcionEventos() {
        super();
    }

    public ExcepcionEventos(String mensaje) {
        super(mensaje);
    }

    public ExcepcionEventos(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public ExcepcionEventos(Throwable causa) {
        super(causa);
    }
}