package com.ingesoft.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ingesoft.domain.Bicicleta;

@Repository
public interface RepositorioBicicletas extends JpaRepository<Bicicleta, Long> {

    @Query("SELECT b FROM Bicicleta b WHERE b.usuario.id = ?1 AND b.descripcion = ?2 ")
    Bicicleta findByUsuarioAndDescripcion(Long idUsuario, String nombreBicicleta);

    @Query("SELECT b FROM Bicicleta b WHERE b.usuario.id = ?1")
    List<Bicicleta> findByUsuario(Long idUsuario);
    
}


