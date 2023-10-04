package com.ingesoft.ejemplo.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
    @GetMapping("/")
    public String getMessage(){
        return "Hola Mundo!";
    }

    @GetMapping("/adios")
    public String getOtherMessage(){
        return "Adios!";
    }
}
