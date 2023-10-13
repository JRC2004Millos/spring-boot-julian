package com.ingesoft.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingesoft.data.RepositorioMarcas;
import com.ingesoft.domain.Marca;

@Service
public class CasosDeUsoMarcas {

    @Autowired
    RepositorioMarcas marcas;

    public void registrarMarca(String nombre) throws ExcepcionMarcas {

        // 1. Actor ingresa el nombre de la marca
        // 2. Sistema valida que no exista otra marca con el mismo nombre
        Marca marcaExistente = marcas.findByNombre(nombre);

        if (marcaExistente != null) {
            throw new ExcepcionMarcas("Ya existe una marca con el mismo nombre");
        }

        // 3. Registramos la marca
        Marca nuevaMarca = new Marca();
        nuevaMarca.setNombre(nombre);

        marcas.save(nuevaMarca);
    }
}
