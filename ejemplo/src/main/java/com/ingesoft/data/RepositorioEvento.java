package com.ingesoft.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.domain.Evento;
import java.util.List;

@Repository
public interface RepositorioEvento extends JpaRepository<Evento, Long> {
    List<Evento> findByNombre(String nombre);
}