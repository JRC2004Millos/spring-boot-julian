package com.ingesoft.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue
    Long id;

    String nombre;
    String clave;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con nombre y clave
    public Usuario(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}