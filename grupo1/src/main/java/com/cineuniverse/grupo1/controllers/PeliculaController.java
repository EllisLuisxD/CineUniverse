package com.cineuniverse.grupo1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cineuniverse.grupo1.models.Peliculas;
import com.cineuniverse.grupo1.services.PeliculaService;

import jakarta.validation.Valid;

@Controller //Usamos para renderizar vistas
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired 
    private PeliculaService peliculaService;


    @ResponseBody // Usamos este bloque solo para hacer llamadas en json usando postman o en la web
    @GetMapping(path = "/{id}")
    public Optional<Peliculas> getUserById(@PathVariable Long id){
	    return this.peliculaService.getById(id);
    }


    @GetMapping("/listarPeliculas")
    public String ListarPeliculas(Model model) {
        List<Peliculas> peliculas = peliculaService.obtenerPaquetesOrdenados();
        model.addAttribute("peliculas", peliculas);
        return "ListarPeliculas";
    }

    @GetMapping("/insertarPeliculas")
    public String InsertarPeliculas() {
        return "InsertarPeliculas";
    }

    // Ruta para recibir los datos del formulario y guardar la pelicula
    @PostMapping("/guardarPelicula")
    public String guardarPelicula(@Valid @ModelAttribute Peliculas peliculas, BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "InsertarPeliculas";  // Vuelve al formulario si hay errores de validación
    }

    try {
        // Prefija la ruta de la imagen con "/img/" if it's not already there
        if (peliculas.getImagen() != null && !peliculas.getImagen().startsWith("/img/")) {
            peliculas.setImagen("/img/" + peliculas.getImagen());
        }
        if (peliculas.getImagenHorizontal() != null && !peliculas.getImagenHorizontal().startsWith("/img/")) {
                        peliculas.setImagenHorizontal("/img/" + peliculas.getImagenHorizontal());
                    }
        
                    peliculaService.guardarPelicula(peliculas);  // Guardamos la pelicula
        return "redirect:/peliculas/insertarPeliculas?success=true";  // Redirigimos con éxito
    } catch (IllegalArgumentException e) {
        model.addAttribute("error", e.getMessage());
        return "InsertarPeliculas";  // Retorna al formulario con el error
    }
}

}
