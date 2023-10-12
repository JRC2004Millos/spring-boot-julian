package com.ingesoft.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.domain.Usuario;



@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuario, Long> {

    // el crea automáticamente
    //  - save
    //  - findAll
    //  - findById
    
    Usuario findByLogin(String login);

}
