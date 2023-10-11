package com.ingesoft.ejemplo.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.ingesoft.logic.CasosDeUsoEventos;
import com.ingesoft.logic.ExcepcionEventos;

public class CasosDeUsoEventosTest1 {

    @Test
    public void testCrearEvento() throws ExcepcionEventos {
        CasosDeUsoEventos casosDeUso = new CasosDeUsoEventos();

        // Prueba 1: Crear un evento válido
        casosDeUso.crearEvento("NombreEvento1", "FechaEvento1");

        // Verifica que el evento se haya creado correctamente
        // Puedes agregar aserciones adicionales aquí
    }

    @Test
    public void testCrearEventoNombreVacio() {
        CasosDeUsoEventos casosDeUso = new CasosDeUsoEventos();

        // Prueba 2: Intentar crear un evento con nombre vacío
        Exception exception = assertThrows(ExcepcionEventos.class, () -> {
            casosDeUso.crearEvento("", "FechaEvento2");
        });

        // Verifica que la excepción sea de tipo ExcepcionEventos
        assertThat(exception).isInstanceOf(ExcepcionEventos.class);
    }

    @Test
    public void testCrearEventoFechaInvalida() {
        CasosDeUsoEventos casosDeUso = new CasosDeUsoEventos();

        // Prueba 3: Intentar crear un evento con una fecha inválida
        Exception exception = assertThrows(ExcepcionEventos.class, () -> {
            casosDeUso.crearEvento("NombreEvento3", "FechaInvalida");
        });

        // Verifica que la excepción sea de tipo ExcepcionEventos
        assertThat(exception).isInstanceOf(ExcepcionEventos.class);
    }
}
