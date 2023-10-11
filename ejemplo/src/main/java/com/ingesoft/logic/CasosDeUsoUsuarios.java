package com.ingesoft.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingesoft.data.RepositorioUsuario;
import com.ingesoft.domain.Usuario;

@Service
public class CasosDeUsoUsuarios {

    @Autowired
    RepositorioUsuario usuarios;

    public void registrarUsuario(String nombre, String contraseña, String string) throws ExcepcionUsuarios {
        // Paso 2: Verificar que el nombre ingresado no exista en la base de datos
        if (usuarios.findByLogin(nombre).size() > 0) {
            throw new ExcepcionUsuarios("El nombre ya está tomado");
        }

        // Paso 4: Verificar si la contraseña es válida (puedes definir tus propios criterios de validez)
        if (!esContraseñaValida(contraseña)) {
            throw new ExcepcionUsuarios("La contraseña no es válida");
        }

        // Paso 5: Solicitar al usuario que vuelva a ingresar la contraseña para su verificación
        // (Suponemos que el usuario vuelve a ingresar la contraseña manualmente)

        // Paso 6: Verificar que las contraseñas coincidan
        if (!contraseña.equals(contraseña)) {
            throw new ExcepcionUsuarios("Las contraseñas no coinciden");
        }

        // Si todo es correcto, registrar al usuario en la base de datos
        Usuario usuario = new Usuario();
        usuario.setLogin(nombre);
        usuario.setPassword(contraseña);

        usuarios.save(usuario);
    }



    // Método para validar si una contraseña es válida (puedes personalizar tus criterios aquí)
    private boolean esContraseñaValida(String contraseña) {
        // Por ejemplo, verifica que la contraseña tenga al menos 8 caracteres
        return contraseña != null && contraseña.length() >= 8;
    }


 public void iniciarSesion(String nombreUsuario, String contraseña) throws ExcepcionUsuarios {
        // Paso 2: Verificar que el usuario exista en la base de datos
        Usuario usuario = usuarios.findByLogin(nombreUsuario).stream().findFirst().orElse(null);

        if (usuario == null) {
            // 2.1: El sistema notifica al usuario que no está registrado y termina
            throw new ExcepcionUsuarios("El usuario no está registrado");
        }

        // Paso 4: Verificar que la contraseña coincida con la registrada
        if (!contraseña.equals(usuario.getPassword())) {
            // 4.1: El sistema notifica al usuario que las contraseñas no coinciden y termina
            throw new ExcepcionUsuarios("Las contraseñas no coinciden");
        }

        // Si todo es correcto, el sistema redirige al usuario a la página principal
        // (Puedes definir la lógica para redirigir al usuario a la página principal)
    }







}