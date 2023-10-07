import static org.junit.Assert.*;
import org.junit.Test;

public class CasosDeUsoUsuariosTest2 {

    @Test
    public void testRegistrarUsuario() throws ExcepcionUsuarios {
        CasosDeUsoUsuarios casosDeUso = new CasosDeUsoUsuarios();

        // Prueba 1: Registrar un usuario válido
        casosDeUso.registrarUsuario("usuario1", "password123", "NombreUsuario");
        
        // Verifica que el usuario se haya registrado correctamente
        
    }

    @Test(expected = ExcepcionUsuarios.class)
    public void testRegistrarUsuarioExistente() throws ExcepcionUsuarios {
        CasosDeUsoUsuarios casosDeUso = new CasosDeUsoUsuarios();

        // Prueba 2: Intentar registrar un usuario con un nombre de usuario existente
        casosDeUso.registrarUsuario("usuario1", "password123", "NombreUsuario");

        // Debería lanzar una excepción ExcepcionUsuarios
    }

    @Test(expected = ExcepcionUsuarios.class)
    public void testRegistrarUsuarioPasswordCorto() throws ExcepcionUsuarios {
        CasosDeUsoUsuarios casosDeUso = new CasosDeUsoUsuarios();

        // Prueba 3: Intentar registrar un usuario con una contraseña demasiado corta
        casosDeUso.registrarUsuario("usuario2", "pass", "NombreUsuario");

        // Debería lanzar una excepción ExcepcionUsuarios
    }
}