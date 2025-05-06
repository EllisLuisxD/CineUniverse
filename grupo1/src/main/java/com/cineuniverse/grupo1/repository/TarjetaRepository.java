package com.cineuniverse.grupo1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineuniverse.grupo1.models.Tarjeta;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {

    // Consultas personalizadas
    Optional<Tarjeta> findByNumeroTarjeta(String numeroTarjeta);
}
