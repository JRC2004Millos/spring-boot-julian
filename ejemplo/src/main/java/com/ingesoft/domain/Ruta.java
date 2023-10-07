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

    // Getters y setters
    public Long getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Long idRuta) {
        this.idRuta = idRuta;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }
}