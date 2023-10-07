package com.ingesoft.logic;

public class ExcepcionRutas extends Exception {

    public ExcepcionRutas() {
        super();
    }

    public ExcepcionRutas(String mensaje) {
        super(mensaje);
    }

    public ExcepcionRutas(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public ExcepcionRutas(Throwable causa) {
        super(causa);
    }
}