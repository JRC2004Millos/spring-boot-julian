package com.ingesoft.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Ruta {
    
    @Id
    @GeneratedValue
    private Long idRuta;

    private double distancia;
    private String origen;
    private String destino;
    private double tiempo;

    // Constructor vacío
    public Ruta() {
    }

    // Constructor con distancia, origen, destino y tiempo
    public Ruta(double distancia, String origen, String destino, double tiempo) {
        this.distancia = distancia;
        this.origen = origen;
        this.destino = destino;
        this.tiempo = tiempo;
    }

    
}