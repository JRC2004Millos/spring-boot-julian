import static org.junit.Assert.*;
import org.junit.Test;

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

    @Test(expected = ExcepcionEventos.class)
    public void testExplorarEventoNoEncontrado() throws ExcepcionEventos {
        CasosDeUsoEventos casosDeUso = new CasosDeUsoEventos();

        // Prueba 2: Intentar explorar eventos con un nombre que no existe
        casosDeUso.explorarEvento("NombreNoExistente");

        // Debería lanzar una excepción ExcepcionEventos
    }
}