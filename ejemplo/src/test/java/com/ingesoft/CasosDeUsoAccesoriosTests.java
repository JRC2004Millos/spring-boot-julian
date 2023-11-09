package com.ingesoft;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ingesoft.data.RepositorioAccesorios;
import com.ingesoft.domain.Accesorio;
import com.ingesoft.logic.CasosDeUsoAccesorios;
import com.ingesoft.logic.ExcepcionAccesorios;

@SpringBootTest
@Tag("integration")
public class CasosDeUsoAccesoriosTests {

    @Autowired
    CasosDeUsoAccesorios casosDeUsoAccesorios;

    @Autowired
    RepositorioAccesorios accesorios;

    @BeforeAll
    public static void prepararAmbienteParaTodaLaSuite() {
        System.out.println("Antes de todas las pruebas de la clase");
        System.out.println();
    }

    @BeforeEach
    public void prepararAmbienteDePruebas() {
        System.out.println("Antes de cada prueba");
        System.out.println();

        accesorios.deleteAll();

        Accesorio accesorioExistente = new Accesorio();
        accesorioExistente.setDescripcion("Luz LED");
        accesorios.save(accesorioExistente);
    }

    @Test
    @Tag("registrarAccesorio")
    public void registrarAccesorioSinErrores() {
        try {
            casosDeUsoAccesorios.registrarAccesorio("Timbre");
            Accesorio nuevoAccesorio = accesorios.findByDescripcion("Timbre");
            assertThat(nuevoAccesorio).isNotNull();
        } catch (ExcepcionAccesorios e) {
            fail("Se generó un error y no debería", e);
        }
    }

    @Test
    @Tag("registrarAccesorio")
    @Tag("errorHandling")
    public void registrarAccesorioConDescripcionRepetida() {
        try {
            casosDeUsoAccesorios.registrarAccesorio("Luz LED");
            fail("Dejó registrar otro accesorio con la misma descripción");
        } catch (ExcepcionAccesorios e) {
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
