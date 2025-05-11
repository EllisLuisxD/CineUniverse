package com.cineuniverse.grupo1.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineuniverse.grupo1.models.Peliculas;
import com.cineuniverse.grupo1.models.Tarjeta;
import com.cineuniverse.grupo1.repository.PeliculaRepository;

@Service
public class PeliculaService {
    @Autowired
    PeliculaRepository peliculaRepository;

    public List<Peliculas> obtenerPaquetesOrdenados() {
        return peliculaRepository.findAllByOrderByFechaEstrenoDesc();
    }

    public Optional<Peliculas> getById(Long id){
        return peliculaRepository.findById(id);
    }

    public List<Peliculas> obtenerPeliculasDesdeAnio(int anio) {
        LocalDate inicioAnio = LocalDate.of(anio, 1, 1);
        return peliculaRepository.findByFechaEstrenoGreaterThanEqualOrderByFechaEstrenoAsc(inicioAnio);
    }

    public List<Peliculas> obtenerPeliculasPorCategoria() {
        return peliculaRepository.findByClasificacion("R");
    }

        // Método que guarda una pelicula
    public void guardarPelicula(Peliculas peliculas) {
        // Validamos si el número de tarjeta ya existe
        Optional<Peliculas> peliculaExistente = peliculaRepository.findByTitulo(peliculas.getTitulo());

        if (peliculaExistente.isPresent()) {
            // Si ya existe, lanzamos una excepción o retornamos un mensaje de error
            throw new IllegalArgumentException("La película con ese título ya existe.");
        }

        // Si no existe, la guardamos en la base de datos
        peliculaRepository.save(peliculas);
    }

}
