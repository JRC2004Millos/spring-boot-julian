package com.ingesoft.ejemplo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


import com.ingesoft.logic.CasosDeUsoUsuarios;

import com.ingesoft.logic.ExcepcionUsuarios;

public class CasosDeUsoUsuariosTest2 {

    @Test
    public void testRegistrarUsuario() throws ExcepcionUsuarios {
        CasosDeUsoUsuarios casosDeUso = new CasosDeUsoUsuarios();

        // Prueba 1: Registrar un usuario válido
        casosDeUso.registrarUsuario("usuario1", "password123", "NombreUsuario");
        
        // Verifica que el usuario se haya registrado correctamente
    }

    @Test
    public void testRegistrarUsuarioExistente() {
        CasosDeUsoUsuarios casosDeUso = new CasosDeUsoUsuarios();

        // Prueba 2: Intentar registrar un usuario con un nombre de usuario existente
        ExcepcionUsuarios excepcion = assertThrows(ExcepcionUsuarios.class, () -> {
            casosDeUso.registrarUsuario("usuario1", "password123", "NombreUsuario");
        });

        // Puedes realizar más verificaciones sobre la excepción si es necesario
        assertThat(excepcion.getMessage()).isEqualTo("El usuario ya está registrado");
    }

    @Test
    public void testRegistrarUsuarioPasswordCorto() {
        CasosDeUsoUsuarios casosDeUso = new CasosDeUsoUsuarios();

        // Prueba 3: Intentar registrar un usuario con una contraseña demasiado corta
        ExcepcionUsuarios excepcion = assertThrows(ExcepcionUsuarios.class, () -> {
            casosDeUso.registrarUsuario("usuario2", "pass", "NombreUsuario");
        });

        // Puedes realizar más verificaciones sobre la excepción si es necesario
        assertThat(excepcion.getMessage()).isEqualTo("La contraseña es demasiado corta");
    }
}