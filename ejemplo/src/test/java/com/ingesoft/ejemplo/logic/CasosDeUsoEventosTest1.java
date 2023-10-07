import static org.junit.Assert.*;
import org.junit.Test;

public class CasosDeUsoEventosTest1 {

    @Test
    public void testCrearEvento() throws ExcepcionEventos {
        CasosDeUsoEventos casosDeUso = new CasosDeUsoEventos();

        // Prueba 1: Crear un evento válido
        casosDeUso.crearEvento("NombreEvento1", "FechaEvento1");

        // Verifica que el evento se haya creado correctamente
        
    }

    @Test(expected = ExcepcionEventos.class)
    public void testCrearEventoNombreVacio() throws ExcepcionEventos {
        CasosDeUsoEventos casosDeUso = new CasosDeUsoEventos();

        // Prueba 2: Intentar crear un evento con nombre vacío
        casosDeUso.crearEvento("", "FechaEvento2");

        // Debería lanzar una excepción ExcepcionEventos
    }

    @Test(expected = ExcepcionEventos.class)
    public void testCrearEventoFechaInvalida() throws ExcepcionEventos {
        CasosDeUsoEventos casosDeUso = new CasosDeUsoEventos();

        // Prueba 3: Intentar crear un evento con una fecha inválida
        casosDeUso.crearEvento("NombreEvento3", "FechaInvalida");

        // Debería lanzar una excepción ExcepcionEventos
    }
}