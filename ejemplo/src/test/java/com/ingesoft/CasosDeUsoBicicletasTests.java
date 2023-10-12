package com.ingesoft;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ingesoft.data.RepositorioBicicletas;
import com.ingesoft.data.RepositorioUsuarios;
import com.ingesoft.domain.Bicicleta;
import com.ingesoft.domain.Usuario;
import com.ingesoft.logic.CasosDeUsoBicicletas;


@SpringBootTest
public class CasosDeUsoBicicletasTests {

    // SUT -- Subject under test
    @Autowired
    CasosDeUsoBicicletas casosDeUsoBicicletas;

    // Fixing -- Clases adicionales necesarias para la prueba
    @Autowired
    RepositorioUsuarios usuarios;

    @Autowired
    RepositorioBicicletas bicicletas;

    // Arrange
    @BeforeAll
    public static void prepararAmbienteParaTodaLaSuite() {
        System.out.println("Antes de todas las pruebas de la clase");
        System.out.println();
    }

    @BeforeEach
    public void prepararAmbienteDePruebas() {
        System.out.println("Antes de cada prueba");
        System.out.println();

        usuarios.deleteAll();
        bicicletas.deleteAll();

        Usuario u = new Usuario();
        u.setLogin("jaime");
        u.setNombre("jaime");
        u.setPassword("jaime");
        usuarios.save(u);
    }

    // CU2: Registrar Bicicleta
    @Test
    public void registrarBicicletaSinErrores() {
        try {
            // Arrange
            Usuario usuario = usuarios.findByLogin("jaime");

            // Act
            casosDeUsoBicicletas.registrarBicicleta(usuario.getLogin(), "Mi Bicicleta");

            // Assert
            List<Bicicleta> bicicletasDelUsuario = bicicletas.findByUsuario(usuario);
            assertThat(bicicletasDelUsuario).isNotEmpty();
        } catch (Exception e) {
            fail("Se generó un error y no debería", e);
        }
    }

    @Test
    public void registrarBicicletaConNombreRepetido() {
        try {
            // Arrange
            Usuario usuario = usuarios.findByLogin("jaime");
            Bicicleta bicicletaExistente = new Bicicleta();
            bicicletaExistente.setDescripcion("Mi Bicicleta");
            bicicletaExistente.setUsuario(usuario);
            bicicletas.save(bicicletaExistente);

            // Act
            casosDeUsoBicicletas.registrarBicicleta(usuario.getLogin(), "Mi Bicicleta");

            // Assert
            fail("Dejó registrar otra bicicleta con el mismo nombre");
        } catch (Exception e) {
            // ok !!
        }
    }

    @AfterEach
    public void despuesDeLaPrueba() {
        System.out.println("Luego de cada prueba");
        System.out.println();
    }

    @AfterAll
    public static void despuesDeTodasLasPruebas() {
        System.out.println("Luego de todas las pruebas");
        System.out.println();
    }
}