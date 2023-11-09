package com.ingesoft;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ingesoft.data.RepositorioMarcas;
import com.ingesoft.domain.Marca;
import com.ingesoft.logic.CasosDeUsoMarcas;
import com.ingesoft.logic.ExcepcionMarcas;

@SpringBootTest
@Tag("integration")
public class CasosDeUsoMarcasTests {

    // SUT -- Subject under test
    @Autowired
    CasosDeUsoMarcas casosDeUsoMarcas;

    // Fixing -- Clases adicionales necesarias para la prueba
    @Autowired
    RepositorioMarcas marcas;

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

        marcas.deleteAll();

        Marca marcaExistente = new Marca();
        marcaExistente.setNombre("Nike");
        marcas.save(marcaExistente);
    }

    // Registrar Marca
    @Test
    @Tag("registrarMarca")
    public void registrarMarcaSinErrores() {

        try {

            // Arrange

            // Act
            casosDeUsoMarcas.registrarMarca("Adidas");

            // Assert
            Marca nuevaMarca = marcas.findByNombre("Adidas");
            assertThat(nuevaMarca).isNotNull();
        } catch (ExcepcionMarcas e) {

            // Mal !!
            fail("Se generó un error y no debería", e);
        }
    }

    @Test
    @Tag("registrarMarca")
    public void registrarMarcaConNombreRepetido() {

        try {

            // Arrange

            // Act
            casosDeUsoMarcas.registrarMarca("Nike");

            // Assert
            fail("Dejó registrar otra marca con el mismo nombre");
        } catch (ExcepcionMarcas e) {
            // OK !!
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
