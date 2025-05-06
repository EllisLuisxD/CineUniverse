package com.cineuniverse.grupo1.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotEmpty(message = "El nombre es obligatorio.")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres.")
    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @NotEmpty(message = "El apellido paterno es obligatorio.")
    @Size(min = 2, max = 50, message = "El apellido paterno debe tener entre 2 y 50 caracteres.")
    @Column(name = "apellido_paterno", length = 45, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 45)
    private String apellidoMaterno;

    @NotEmpty(message = "La contraseña es obligatoria.")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres.")
    @Column(name = "contraseña", length = 60, nullable = false) // Longitud recomendada para contraseñas hasheadas
    private String contraseña;

    @NotEmpty(message = "El DNI es obligatorio.")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos.")
    @Column(name = "dni", length = 8, unique = true, nullable = false)
    private String dni;

    @NotNull(message = "La fecha de nacimiento es obligatoria.")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "celular", length = 15)
    private String celular;

    @Column(name = "genero", length = 1) // Puedes usar 'M' para masculino, 'F' para femenino, etc.
    private String genero;

    @Column(name = "departamento", length = 45)
    private String departamento;

    // Getters y setters para todos los atributos
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
