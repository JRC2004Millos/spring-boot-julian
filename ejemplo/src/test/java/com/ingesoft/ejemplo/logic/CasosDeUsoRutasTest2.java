import static org.junit.Assert.*;
import org.junit.Test;

public class CasosDeUsoRutasTest2 {

    @Test
    public void testExplorarRutas() throws ExcepcionRutas {
        CasosDeUsoRutas casosDeUso = new CasosDeUsoRutas();

        // Prueba 1: Explorar rutas válidas
        casosDeUso.explorarRutas("LugarPartida1", "LugarDestino1");

        // Verifica que las rutas se hayan explorado correctamente
        
    }

    @Test(expected = ExcepcionRutas.class)
    public void testExplorarRutasLugarNoExistente() throws ExcepcionRutas {
        CasosDeUsoRutas casosDeUso = new CasosDeUsoRutas();

        // Prueba 2: Intentar explorar rutas con un lugar de partida inexistente
        casosDeUso.explorarRutas("LugarNoExistente", "LugarDestino2");

        // Debería lanzar una excepción ExcepcionRutas
    }
}