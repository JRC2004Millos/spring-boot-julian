package com.ingesoft.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingesoft.modelo.Usuario;
import java.util.List;

public class RepositorioUsuarios extends JpaRepository<Usuario, long>{

    List<Usuario> usuarios;

    public List<Usuario> findByLogin(String login){
        List <Usuario> usuariosConLogin;
        for(Usuario u : usuarios){
            if(u.getNombre().equalsIgnoreCase(login)){
                usuariosConLogin.add(u);
            }
        }
        return usuariosConLogin;
    }
}
