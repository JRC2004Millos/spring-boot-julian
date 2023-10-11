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

    public void setPassword(String contraseña) {
    }

    public void setLogin(String nombre2) {
    }

    public Object getPassword() {
        return null;
    }

}