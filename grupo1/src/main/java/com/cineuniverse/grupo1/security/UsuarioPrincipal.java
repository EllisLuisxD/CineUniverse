package com.cineuniverse.grupo1.security;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cineuniverse.grupo1.models.Usuarios;

public class UsuarioPrincipal implements UserDetails {
    private Usuarios usuario;

    public UsuarioPrincipal(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Aquí puedes definir los roles del usuario si los tienes
        return java.util.Collections.emptyList(); // Ejemplo sin roles por ahora
    }

    @Override
    public String getPassword() {
        return usuario.getContraseña();
    }

    @Override
    public String getUsername() {
        return usuario.getDni();
    }

    // Agrega los getters para los campos de Usuarios a los que quieras acceder
    public String getNombre() {
        return usuario.getNombre();
    }

    public String getApellidoPaterno() {
        return usuario.getApellidoPaterno();
    }

    public String getApellidoMaterno() {
        return usuario.getApellidoMaterno();
    }

    public String getCelular() {
        return usuario.getCelular();
    }

    public String getGenero() {
        return usuario.getGenero();
    }

    public String getDepartamento() {
        return usuario.getDepartamento();
    }

    public LocalDate getFechaNacimiento() {
        return usuario.getFechaNacimiento();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
