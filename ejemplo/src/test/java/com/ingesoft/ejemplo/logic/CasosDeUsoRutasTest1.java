import static org.junit.Assert.*;
import org.junit.Test;

public class CasosDeUsoRutasTest1 {

    @Test
    public void testPlanificarRutas() throws ExcepcionRutas {
        CasosDeUsoRutas casosDeUso = new CasosDeUsoRutas();

        // Prueba 1: Planificar una ruta válida
        casosDeUso.planificarRutas("LugarPartida1", "LugarDestino1", "FechaHora1");

        // Verifica que la ruta se haya planificado correctamente
        
    }

    @Test(expected = ExcepcionRutas.class)
    public void testPlanificarRutasLugarNoExistente() throws ExcepcionRutas {
        CasosDeUsoRutas casosDeUso = new CasosDeUsoRutas();

        // Prueba 2: Intentar planificar una ruta con un lugar de partida inexistente
        casosDeUso.planificarRutas("LugarNoExistente", "LugarDestino2", "FechaHora2");

        // Debería lanzar una excepción ExcepcionRutas
    }

    @Test(expected = ExcepcionRutas.class)
    public void testPlanificarRutasFechaInvalida() throws ExcepcionRutas {
        CasosDeUsoRutas casosDeUso = new CasosDeUsoRutas();

        // Prueba 3: Intentar planificar una ruta con una fecha inválida
        casosDeUso.planificarRutas("LugarPartida3", "LugarDestino3", "FechaHoraInvalida");

        // Debería lanzar una excepción ExcepcionRutas
    }
}