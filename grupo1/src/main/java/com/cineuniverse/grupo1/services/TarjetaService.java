package com.cineuniverse.grupo1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineuniverse.grupo1.models.Tarjeta;
import com.cineuniverse.grupo1.repository.TarjetaRepository;

@Service
public class TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    // Método que guarda una tarjeta
    public void guardarTarjeta(Tarjeta tarjeta) {
        // Validamos si el número de tarjeta ya existe
        Optional<Tarjeta> tarjetaExistente = tarjetaRepository.findByNumeroTarjeta(tarjeta.getNumeroTarjeta());

        if (tarjetaExistente.isPresent()) {
            // Si ya existe, lanzamos una excepción o retornamos un mensaje de error
            throw new IllegalArgumentException("La tarjeta con ese número ya está registrada.");
        }

        // Si no existe, la guardamos en la base de datos
        tarjetaRepository.save(tarjeta);
    }
}
