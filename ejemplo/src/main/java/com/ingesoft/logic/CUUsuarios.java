package com.ingesoft.logic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.ingesoft.data.RepositorioUsuarios;
import com.ingesoft.modelo.Usuario;

public class CUUsuarios {

    @Autowired
    RepositorioUsuarios usuarios;

    //CU01 Registrar Usuario
    public void registrarUsuario(String login, String password) throws ExcepcionUsuarios{
        List <Usuario> usuariosExistentes = usuarios.findByLogin(login);
        
        if(usuariosExistentes.size() > 0){
            throw new ExcepcionUsuarios("Existre otro usuario con ese login");
        }

        if(password.trim().length() < 5){
            throw new ExcepcionUsuarios("El password tiene menos de 5 letras");
        }

        Usuario u = new Usuario ();
        u.setNombre(login);
        u.setContraseña(password);

        usuarios.save(u);
    }
}
