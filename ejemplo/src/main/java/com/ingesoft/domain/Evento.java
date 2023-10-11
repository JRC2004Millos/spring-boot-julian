package com.ingesoft.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Evento {
    
    @Id
    @GeneratedValue
    private Long id;

    private String fecha;
    private String nombre;

    // Constructor vacío
    public Evento() {
    }

    // Constructor con fecha y nombre
    public Evento(String fecha, String nombre) {
        this.fecha = fecha;
        this.nombre = nombre;
    }

    
}