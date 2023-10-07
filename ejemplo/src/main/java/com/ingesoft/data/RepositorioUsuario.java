package com.ingesoft.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.domain.Usuario;
import java.util.List;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    List<Usuario> findByLogin(String login);
}