package com.ingesoft.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Marca {

    @Id
    @GeneratedValue
    Long id;

    String nombre;

    @OneToMany(mappedBy = "marca")
    List<Bicicleta> bicicletas = new ArrayList<>();
}