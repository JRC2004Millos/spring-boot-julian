package com.ingesoft.ejemplo.logic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import com.ingesoft.data.RepositorioUsuarios;
import com.ingesoft.logic.CUUsuarios;
import com.ingesoft.logic.ExcepcionUsuarios;
import com.ingesoft.modelo.Usuario;

@SpringBootTest
public class CUUsuariosTests {

    @Autowired
    CUUsuarios cuUsuarios;

    @Autowired
    RepositorioUsuarios usuarios;

    @BeforeAll
    public static void prepararAmbienteParaTodaLaSuite(){
        System.out.println("Antes de todas las pruebas de la clase");
        System.out.println();
    }

    @BeforeEach
    public void prepararAmbienteDePruebas(){
        System.out.println("Antes de cada prueba");
    }

    @Test
    public void registrarUsuarioSinErrores(){

        try{

            //Arrange

            //Act
            cuUsuarios.registrarUsuario("Julian", "SoloMillos16");

            //Assert
            List <Usuario> usuariosConNombreJulian = usuarios.findByLogin("Julian");

            if(usuariosConNombreJulian.size() == 0){
                fail("No se grabó el usuario");
            }
        } catch(ExcepcionUsuarios e){
            fail("Se generó error y no debería", e);
        }
    }

    @Test
    public void registrarUsuarioConLoginQueYaExiste(){
        try{
            usuarios.deleteAll();

            Usuario u = new Usuario();
            u.setNombre("Julian");
            u.setContraseña("SoloMillos");
            usuarios.save(u);

            cuUsuarios.registrarUsuario("Julian", "SoloMillos");

            fail("Dejó grabar otro usuario con un login que ya existe");
        } catch(ExcepcionUsuarios e){

        }
    }

    @Test
    public void registrarUsuarioConPasswordDeMenosDe5Letras(){
        try{

            //Arrange
            usuarios.deleteAll();

            //Act
            cuUsuarios.registrarUsuario("Julian", "xx");

            //Assert
            fail("Dejó grabar el usuario con una contraseña de menos de 5 letras");

        }catch(ExcepcionUsuarios e){

        }
    }

    //Clean up
    @AfterEach
    public void despuesDeLaPrueba(){
        System.out.println("Luego de cada prueba");
        System.out.println();
    }

    @AfterAll
    public static void despuesDeTodasLasPruebas(){
        System.out.println("Luego de todas las pruebas");
    }
}
