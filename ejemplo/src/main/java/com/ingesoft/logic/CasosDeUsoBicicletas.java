package com.ingesoft.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingesoft.data.RepositorioBicicletas;
import com.ingesoft.data.RepositorioUsuarios;
import com.ingesoft.domain.Bicicleta;
import com.ingesoft.domain.Usuario;

@Service
public class CasosDeUsoBicicletas {

    @Autowired
    RepositorioBicicletas bicicletas;

    @Autowired
    RepositorioUsuarios usuarios;


    public void registrarBicicleta(String login, String nombreBicicleta) throws Exception {

        // 1. Actor ingresa el login del usuario
        // 2. Sistema valida que exista un usuario con ese login
        Usuario usuario = usuarios.findByLogin(login);

        if (usuario == null) {
            throw new Exception("Usuario no encontrado");
        }

        // 3. Actor ingresa el nombre de la bicicleta
        // 4. Sistema valida que ese usuario no tenga otra bicicleta con el mismo nombre
        Bicicleta bicicletaExistente = bicicletas.findByUsuarioAndDescripcion(usuario.getId(), nombreBicicleta);

        if (bicicletaExistente != null) {
            throw new Exception("El usuario ya tiene una bicicleta con el mismo nombre");
        }

        // 5. Registramos la bicicleta para ese usuario
        Bicicleta nuevaBicicleta = new Bicicleta();
        nuevaBicicleta.setDescripcion(nombreBicicleta);
        nuevaBicicleta.setUsuario(usuario);
        bicicletas.save(nuevaBicicleta);

        usuario.getBicicletas().add(nuevaBicicleta);
        usuarios.save(usuario);
    }
}