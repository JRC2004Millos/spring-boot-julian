package com.ingesoft.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CasosDeUsoEventos {

    private static List<Evento> eventos = new ArrayList<>();
    private static long eventoId = 1;

    public Evento crearEvento(String nombreEvento, String fechaEvento) throws ExcepcionEventos {
        // Paso 1: Crear un nuevo evento con un ID único
        Evento nuevoEvento = new Evento();
        nuevoEvento.setId(eventoId++);
        nuevoEvento.setNombre(nombreEvento);
        nuevoEvento.setFecha(fechaEvento);

        // Paso 2: Validar que el nombre del evento no esté vacío
        if (nombreEvento == null || nombreEvento.trim().isEmpty()) {
            throw new ExcepcionEventos("El nombre del evento no puede estar vacío");
        }

        // Paso 3: Validar que la fecha del evento sea válida (puedes definir tus criterios de validez)
        if (fechaEvento == null || !esFechaValida(fechaEvento)) {
            throw new ExcepcionEventos("La fecha del evento no es válida");
        }

        // Paso 4: Agregar el evento a la lista de eventos
        eventos.add(nuevoEvento);

        // Paso 5: Devolver el evento creado
        return nuevoEvento;
    }

    private boolean esFechaValida(String fecha) {
        // Lógica para validar si la fecha es válida (puedes personalizar tus criterios aquí)
        // En esta implementación, suponemos que cualquier cadena no nula o vacía se considera válida.
        return fecha != null && !fecha.trim().isEmpty();
    }


    public List<Evento> explorarEvento(String nombreEvento) throws ExcepcionEventos {
        // Paso 1: Buscar eventos por nombre
        List<Evento> eventosEncontrados = eventos.stream()
                .filter(evento -> evento.getNombre().equalsIgnoreCase(nombreEvento))
                .collect(Collectors.toList());

        // Paso 2: Si no se encontraron eventos con el nombre proporcionado, lanzar excepción
        if (eventosEncontrados.isEmpty()) {
            throw new ExcepcionEventos("No se encontraron eventos con el nombre: " + nombreEvento);
        }

        // Retornar la lista de eventos encontrados
        return eventosEncontrados;
    }








}