package com.ingesoft.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Administrador {
    
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String password;

    // Constructor vacío
    public Administrador() {
    }

    // Constructor con nombre y clave
    public Administrador(String nombre, String clave) {
        this.nombre = nombre;
        
    }

    
}