package com.ingesoft.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity
public class Tarea {
    
    @Id
    @GeneratedValue
    Long id;

    String tarea;

    String descripcion;

    boolean completado;

    
}
