package com.ingesoft.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.domain.Administrador;
import java.util.List;

@Repository
public interface RepositorioAdministrador extends JpaRepository<Administrador, Long> {
    List<Administrador> findByNombre(String nombre);
}