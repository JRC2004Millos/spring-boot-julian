package com.ingesoft.ejemplo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.modelo.Tarea;

@Repository
public interface TareasRepository extends JpaRepository<Tarea, Long>{
    
}
