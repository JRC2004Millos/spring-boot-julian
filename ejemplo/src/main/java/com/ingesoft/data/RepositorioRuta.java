package com.ingesoft.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.domain.Ruta;

@Repository
public interface RepositorioRuta extends JpaRepository<Ruta, Long> {
   
}