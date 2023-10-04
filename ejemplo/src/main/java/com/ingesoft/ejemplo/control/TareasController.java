package com.ingesoft.ejemplo.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingesoft.ejemplo.repositorio.TareasRepository;
import com.ingesoft.modelo.Tarea;

@RestController
@RequestMapping("/tareas")
public class TareasController {
    private final TareasRepository tareasRepository;

    //Un repositorio
    //Este objeto lo va a crear Spring Boot
    public TareasController(TareasRepository tareasRepository){
        this.tareasRepository = tareasRepository;
    }

    @GetMapping("/")
    public Iterable<Tarea> getTareas(){
        return tareasRepository.findAll();
    }

    @GetMapping("/")
    public Tarea crearTarea(@RequestBody Tarea tarea){
        return tareasRepository.save(tarea);
    }
}
