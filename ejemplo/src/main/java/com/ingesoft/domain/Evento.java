package com.ingesoft.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Data;

@Data
@Entity
public class Evento {
    
    @Id
    @GeneratedValue
    private Long id;

    private Date fecha;
    private String nombre;

    // Constructor vacío
    public Evento() {
    }

    // Constructor con fecha y nombre
    public Evento(Date fecha, String nombre) {
        this.fecha = fecha;
        this.nombre = nombre;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}