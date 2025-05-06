package com.cineuniverse.grupo1.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cineuniverse.grupo1.models.Usuarios;
import com.cineuniverse.grupo1.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuarios registrarUsuario(Usuarios usuario) {
        // Validación específica para verificar si el DNI ya existe
        if (usuarioRepository.findByDni(usuario.getDni()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un usuario registrado con este DNI.");
        }

        // Encriptar la contraseña antes de guardar
        String contraseñaEncriptada = passwordEncoder.encode(usuario.getContraseña());
        usuario.setContraseña(contraseñaEncriptada);

        // Guardar el usuario en la base de datos
        return usuarioRepository.save(usuario);
    }

    // Método para buscar usuario por DNI (lo usamos en las validaciones)
    public Optional<Usuarios> findByDni(String dni) {
        return usuarioRepository.findByDni(dni);
    }
}
