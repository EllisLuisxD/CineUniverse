package com.cineuniverse.grupo1.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Salas")
public class Salas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSala")
    private Long idSala;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "formato")
    private List<String> formato;

    // Getters y setters
    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public List<String> getTipo() {
        return formato;
    }

    public void setTipo(List<String> formato) {
        this.formato = formato;
    }
}
