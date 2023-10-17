package com.ingesoft.domain;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Bicicleta {
    
    @Id
    @GeneratedValue
    Long id;

    String descripcion;

    @ManyToOne
    Usuario usuario;
    @ManyToOne
    Marca marca;
    @ManyToOne
    Accesorio accesorio;

}

