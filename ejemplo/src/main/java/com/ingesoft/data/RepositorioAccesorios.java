package com.ingesoft.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.domain.Accesorio;


@Repository
public interface RepositorioAccesorios extends JpaRepository<Accesorio, Long> {
 
    Accesorio findByDescripcion(String descripcion);
    
}