package com.ingesoft.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.domain.Bicicleta;
import com.ingesoft.domain.Usuario;

@Repository
public interface RepositorioBicicletas extends JpaRepository<Bicicleta, Long> {

    Bicicleta findByUsuarioAndDescripcion(List<Usuario> usuario, String nombreBicicleta);

    List<Bicicleta> findByUsuario(Usuario usuario);
    
}


