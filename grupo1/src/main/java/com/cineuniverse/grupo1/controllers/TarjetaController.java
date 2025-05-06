package com.cineuniverse.grupo1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cineuniverse.grupo1.models.Tarjeta;
import com.cineuniverse.grupo1.services.TarjetaService;

import jakarta.validation.Valid;

@Controller
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    // Ruta para mostrar el formulario de creación de tarjeta
    @GetMapping("/tarjetas/nueva")
    public String mostrarFormularioDeCreacion() {
        return "Tarjetas";  // Vista que quieres mostrar en la pagina
    }

    // Ruta para recibir los datos del formulario y guardar la tarjeta
    @PostMapping("/tarjetas/guardar")
public String guardarTarjeta(@Valid @ModelAttribute Tarjeta tarjeta, BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "Tarjetas";  // Vuelve al formulario si hay errores de validación
    }

    try {
        tarjetaService.guardarTarjeta(tarjeta);  // Guardamos la tarjeta
        return "redirect:/tarjetas/nueva?success=true";  // Redirigimos con éxito
    } catch (IllegalArgumentException e) {
        model.addAttribute("error", e.getMessage());
        return "Tarjetas";  // Retorna al formulario con el error
    }
}

}
