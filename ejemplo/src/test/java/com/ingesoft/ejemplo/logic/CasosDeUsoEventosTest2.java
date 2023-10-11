package com.ingesoft.ejemplo.logic;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.ingesoft.domain.Evento;
import com.ingesoft.logic.CasosDeUsoEventos;
import com.ingesoft.logic.ExcepcionEventos;

public class CasosDeUsoEventosTest2 {

    @Test
    public void testExplorarEvento() throws ExcepcionEventos {
        CasosDeUsoEventos casosDeUso = new CasosDeUsoEventos();

        // Prueba 1: Explorar eventos válidos por nombre
        casosDeUso.crearEvento("NombreEvento1", "FechaEvento1");
        casosDeUso.crearEvento("NombreEvento1", "FechaEvento2");

        // Explorar eventos con el mismo nombre
        List<Evento> eventosEncontrados = casosDeUso.explorarEvento("NombreEvento1");

        // Verifica que se hayan encontrado eventos
        assertNotNull(eventosEncontrados);
        // Verifica que la lista de eventos no esté vacía
        assertFalse(eventosEncontrados.isEmpty());
        
    }

    @Test
    public void testExplorarEventoNoEncontrado() {
        CasosDeUsoEventos casosDeUso = new CasosDeUsoEventos();

        // Prueba 2: Intentar explorar eventos con un nombre que no existe
        Executable executable = () -> casosDeUso.explorarEvento("NombreNoExistente");
        
        // Debería lanzar una excepción ExcepcionEventos
        assertThrows(ExcepcionEventos.class, executable);
    }
}