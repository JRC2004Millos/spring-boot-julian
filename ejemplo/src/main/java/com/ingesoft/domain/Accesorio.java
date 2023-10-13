package com.ingesoft.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Accesorio {

    @Id
    @GeneratedValue
    Long id;

    @Column(unique = true)
    String descripcion;
}
