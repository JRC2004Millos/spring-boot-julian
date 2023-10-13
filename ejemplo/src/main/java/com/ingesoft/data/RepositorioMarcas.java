package com.ingesoft.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.domain.Marca;

@Repository
public interface RepositorioMarcas extends JpaRepository<Marca, Long> {
    
    Marca findByNombre(String nombre);
}