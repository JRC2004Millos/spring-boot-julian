import static org.junit.Assert.*;
import org.junit.Test;

public class CasosDeUsoUsuariosTest1 {

    @Test
    public void testIniciarSesion() throws ExcepcionUsuarios {
        CasosDeUsoUsuarios casosDeUso = new CasosDeUsoUsuarios();

        // Prueba 1: Iniciar sesión con credenciales válidas
        casosDeUso.registrarUsuario("usuario1", "password123", "NombreUsuario");
        casosDeUso.iniciarSesion("usuario1", "password123");

        // Verifica que la sesión se haya iniciado correctamente
      
    }

    @Test(expected = ExcepcionUsuarios.class)
    public void testIniciarSesionUsuarioNoRegistrado() throws ExcepcionUsuarios {
        CasosDeUsoUsuarios casosDeUso = new CasosDeUsoUsuarios();

        // Prueba 2: Intentar iniciar sesión con un usuario no registrado
        casosDeUso.iniciarSesion("usuario2", "password456");

        // Debería lanzar una excepción ExcepcionUsuarios
    }

    @Test(expected = ExcepcionUsuarios.class)
    public void testIniciarSesionPasswordIncorrecto() throws ExcepcionUsuarios {
        CasosDeUsoUsuarios casosDeUso = new CasosDeUsoUsuarios();

        // Prueba 3: Intentar iniciar sesión con contraseña incorrecta
        casosDeUso.registrarUsuario("usuario3", "password123", "NombreUsuario");
        casosDeUso.iniciarSesion("usuario3", "contraseñaIncorrecta");

        // Debería lanzar una excepción ExcepcionUsuarios
    }
}