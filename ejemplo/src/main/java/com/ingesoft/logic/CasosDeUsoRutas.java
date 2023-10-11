package com.ingesoft.logic;

import org.springframework.stereotype.Service;

@Service
public class CasosDeUsoRutas {

    /**
     * @param lugarPartida
     * @param lugarDestino
     * @param fechaHoraPartida
     * @throws ExcepcionRutas
     */
    public void planificarRutas(String lugarPartida, String lugarDestino, String fechaHoraPartida) throws ExcepcionRutas {
        // Paso 4: Verificar que el lugar de partida exista en el mapa
        if (!lugarExisteEnMapa(lugarPartida)) {
            // 4.1: El sistema muestra el mensaje de error "El lugar de partida no se ha encontrado" y vuelve a solicitar la entrada del usuario
            throw new ExcepcionRutas("El lugar de partida no se ha encontrado");
        }

        // Paso 5: Verificar que el lugar de destino exista en el mapa
        if (!lugarExisteEnMapa(lugarDestino)) {
            // 5.1: El sistema muestra el mensaje de error "El lugar de destino no se ha encontrado" y vuelve a solicitar la entrada del usuario
            throw new ExcepcionRutas("El lugar de destino no se ha encontrado");
        }

       
    }





     public void explorarRutas(String lugarPartida, String lugarDestino) throws ExcepcionRutas {
        // Paso 4: Verificar que tanto el lugar de destino como el punto de partida existan en el mapa
        if (!lugarExisteEnMapa(lugarPartida) || !lugarExisteEnMapa(lugarDestino)) {
            // 4.1: Si el sistema no encuentra el lugar de destino o de partida en el mapa,
            // muestra el mensaje de error y vuelve a solicitar al usuario que ingrese los lugares.
            throw new ExcepcionRutas("El lugar de destino o de partida no se han encontrado");
        }

        
    }

    private boolean lugarExisteEnMapa(String lugar) {
        // Lógica para verificar si un lugar existe en el mapa
        
        return false; 
    }















}