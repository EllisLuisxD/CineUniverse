package com.cineuniverse.grupo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Usamos para renderizar vistas
@RequestMapping("/insertarPeliculas")
public class InsertarPelController{

    @GetMapping("/enviarPelis")
    public String InsertarPeliculas() {
        return "InsertarPeliculas";
    }
}

