package com.ingesoft.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class Usuario {

    @Id
    protected long id;

    protected String nombre;

    protected String contraseña;
    
    protected boolean administrador;

    protected boolean registrado;

    public String getNombre() {
        return nombre;
    }

    // Setter para el atributo 'nombre'
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para el atributo 'contraseña'
    public String getContraseña() {
        return contraseña;
    }

    // Setter para el atributo 'contraseña'
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    // Getter para el atributo 'administrador'
    public boolean isAdministrador() {
        return administrador;
    }

    // Setter para el atributo 'administrador'
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    // Getter para el atributo 'registrado'
    public boolean isRegistrado() {
        return registrado;
    }

    // Setter para el atributo 'registrado'
    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }
}
