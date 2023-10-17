package com.ingesoft.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Accesorio {

    @Id
    @GeneratedValue
    Long id;

    @Column(unique = true)
    String descripcion;

    @OneToMany(mappedBy = "accesorio")
    List<Bicicleta> bicicletas = new ArrayList<>();
}
