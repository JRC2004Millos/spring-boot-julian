package com.ingesoft.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingesoft.data.RepositorioAccesorios;
import com.ingesoft.domain.Accesorio;

@Service
public class CasosDeUsoAccesorios {

    @Autowired
    RepositorioAccesorios accesorios;

    public void registrarAccesorio(String descripcion) throws ExcepcionAccesorios {

        // 1. Actor ingresa la descripción del accesorio
        // 2. Sistema valida que no exista otro accesorio con la misma descripción
        Accesorio accesorioExistente = accesorios.findByDescripcion(descripcion);

        if (accesorioExistente != null) {
            throw new ExcepcionAccesorios("Ya existe un accesorio con la misma descripción");
        }

        // 3. Registramos el accesorio
        Accesorio nuevoAccesorio = new Accesorio();
        nuevoAccesorio.setDescripcion(descripcion);

        accesorios.save(nuevoAccesorio);
    }
}
