package com.ingesoft.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingesoft.data.RepositorioUsuarios;
import com.ingesoft.domain.Usuario;

@Service
public class CasosDeUsoUsuarios {
    
    @Autowired
    RepositorioUsuarios usuarios;

    // CU1: Registrar Usuario
    public void registrarUsuario (
        String login,       // 1. Actor ingresa login
        String password,    // 3. Actor ingresa password
        String nombre       // 5. Actor ingresa nombre
    ) throws ExcepcionUsuarios {

        // 2. Sistema valida que no exista otro usuario con ese login
        Usuario usuariosExistentes = usuarios.findByLogin(login);

        // (2) Cuando existe otro usuario con ese login
        if (usuariosExistentes != null) {
            // 2.1. Sistema muestra un mensaje "Existe otro usuario con ese login"
            // 2.2. Sistema termina
            throw new ExcepcionUsuarios("Existe otro usuario con ese login");
        }

        // 4. Sistema valida que el password tenga más de cinco letras 
        // (4) Cuando el password tiene menos de cinco letras
        if (password.trim().length() < 5) {
            // 4.1. Sistema muestra un mensaje "El password tiene menos de cinco letras"
            // 4.2. Sistema termina.
            throw new ExcepcionUsuarios("El password tiene menos de cinco letras");
        }

        // 6. Sistema registra el usuario
        Usuario u = new Usuario();
        u.setLogin(login);
        u.setNombre(nombre);
        u.setPassword(password);

        usuarios.save(u);

    }


}
