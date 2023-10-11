package com.ingesoft.ejemplo.logic;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.ingesoft.logic.CasosDeUsoRutas;
import com.ingesoft.logic.ExcepcionRutas;

public class CasosDeUsoRutasTest1 {

    @Test
    public void testPlanificarRutas() throws ExcepcionRutas {
        CasosDeUsoRutas casosDeUso = new CasosDeUsoRutas();

        // Prueba 1: Planificar una ruta válida
        casosDeUso.planificarRutas("LugarPartida1", "LugarDestino1", "FechaHora1");

        // Verifica que la ruta se haya planificado correctamente
        
    }

    @Test
    public void testPlanificarRutasLugarNoExistente() {
        CasosDeUsoRutas casosDeUso = new CasosDeUsoRutas();

        // Prueba 2: Intentar planificar una ruta con un lugar de partida inexistente
        Executable executable = () -> casosDeUso.planificarRutas("LugarNoExistente", "LugarDestino2", "FechaHora2");
        
        // Debería lanzar una excepción ExcepcionRutas
        assertThrows(ExcepcionRutas.class, executable);
    }

    @Test
    public void testPlanificarRutasFechaInvalida() {
        CasosDeUsoRutas casosDeUso = new CasosDeUsoRutas();

        // Prueba 3: Intentar planificar una ruta con una fecha inválida
        Executable executable = () -> casosDeUso.planificarRutas("LugarPartida3", "LugarDestino3", "FechaHoraInvalida");
        
        // Debería lanzar una excepción ExcepcionRutas
        assertThrows(ExcepcionRutas.class, executable);
    }
}