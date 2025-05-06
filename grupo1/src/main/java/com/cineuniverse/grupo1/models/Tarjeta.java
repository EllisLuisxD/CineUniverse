package com.cineuniverse.grupo1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Tarjeta")
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTarjeta")
    private Integer idTarjeta;

    @Column(name = "nombreTitular", nullable = false)
    private String nombreTitular;

    @Column(name = "apellidoTitular", nullable = false)
    private String apellidoTitular;

    @Column(name = "numeroTarjeta", nullable = false, unique = true)
    private String numeroTarjeta;

    @Column(name = "cvv", nullable = false)
    private String cvv;
    
    @Pattern(regexp = "^(0[1-9]|1[0-2])/\\d{2}$", message = "Formato inválido. Usa MM/AA.")
    @Column(name = "fechaVencimiento", nullable = false)
    private String fechaVencimiento;

    @Column(name = "codigoPostal", nullable = false)
    private String codigoPostal;

    // Getters and Setters
    public Integer getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getApellidoTitular() {
        return apellidoTitular;
    }

    public void setApellidoTitular(String apellidoTitular) {
        this.apellidoTitular = apellidoTitular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
}
}
