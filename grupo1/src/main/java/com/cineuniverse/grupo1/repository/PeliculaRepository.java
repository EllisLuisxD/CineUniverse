package com.cineuniverse.grupo1.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineuniverse.grupo1.models.Peliculas;

@Repository
public interface PeliculaRepository extends JpaRepository<Peliculas, Long>{
    List<Peliculas> findAllByOrderByFechaEstrenoDesc();

    List<Peliculas> findByFechaEstrenoGreaterThanEqualOrderByFechaEstrenoAsc(LocalDate startDate);

    List<Peliculas> findByClasificacion(String clasificacion);

    // Consultas personalizadas
    Optional<Peliculas> findByTitulo(String titulo);
}
