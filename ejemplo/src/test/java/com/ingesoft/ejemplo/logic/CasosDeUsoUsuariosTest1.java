package com.ingesoft.ejemplo.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test; // Asegúrate de importar la anotación @Test desde el paquete correcto


import com.ingesoft.logic.CasosDeUsoUsuarios;

import com.ingesoft.logic.ExcepcionUsuarios;

public class CasosDeUsoUsuariosTest1 {

    @Test
    public void testIniciarSesion() throws ExcepcionUsuarios {
        CasosDeUsoUsuarios casosDeUso = new CasosDeUsoUsuarios();

        // Prueba 1: Iniciar sesión con credenciales válidas
        casosDeUso.registrarUsuario("usuario1", "password123", "NombreUsuario");
        casosDeUso.iniciarSesion("usuario1", "password123");

        // Verifica que la sesión se haya iniciado correctamente
    }

    @Test
    public void testIniciarSesionUsuarioNoRegistrado() {
        CasosDeUsoUsuarios casosDeUso = new CasosDeUsoUsuarios();

        // Prueba 2: Intentar iniciar sesión con un usuario no registrado
        ExcepcionUsuarios excepcion = assertThrows(ExcepcionUsuarios.class, () -> {
            casosDeUso.iniciarSesion("usuario2", "password456");
        });

        // Puedes realizar más verificaciones sobre la excepción si es necesario
        assertThat(excepcion.getMessage()).isEqualTo("El usuario no está registrado");
    }

    @Test
    public void testIniciarSesionPasswordIncorrecto() throws ExcepcionUsuarios {
        CasosDeUsoUsuarios casosDeUso = new CasosDeUsoUsuarios();

        // Prueba 3: Intentar iniciar sesión con contraseña incorrecta
        casosDeUso.registrarUsuario("usuario3", "password123", "NombreUsuario");
        ExcepcionUsuarios excepcion = assertThrows(ExcepcionUsuarios.class, () -> {
            casosDeUso.iniciarSesion("usuario3", "contraseñaIncorrecta");
        });

        // Puedes realizar más verificaciones sobre la excepción si es necesario
        assertThat(excepcion.getMessage()).isEqualTo("Las contraseñas no coinciden");
    }
}