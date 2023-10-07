package com.ingesoft.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.domain.Ruta;
import java.util.List;

@Repository
public interface RepositorioRuta extends JpaRepository<Ruta, Long> {
    // Agregar métodos personalizados para buscar rutas si es necesario
}