package com.cineuniverse.grupo1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cineuniverse.grupo1.models.Usuarios;
import com.cineuniverse.grupo1.services.UsuarioService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/registro")
public class RegistroController {

	private UsuarioService usuarioService;
    private AuthenticationManager authenticationManager;

    public RegistroController(UsuarioService usuarioService, AuthenticationManager authenticationManager) {
        this.usuarioService = usuarioService;
        this.authenticationManager = authenticationManager;
    }
	
	@GetMapping("/usuario")
	public String mostrarFormularioRegistro(Model model) {
		model.addAttribute("usuario", new Usuarios()); // Inicializa un objeto usuario vacío para el formulario
		return "RegistroUsuario";
	}
	

    @PostMapping("/usuario")
public String registrarCuentaDeUsuario(@Valid @ModelAttribute("usuario") Usuarios usuario, BindingResult result, Model model) {
    System.out.println("DTO recibido en el controlador (POST): " + usuario);

    if (result.hasErrors()) {
        System.out.println("¡Se encontraron errores de validación!");
        return "RegistroUsuario"; // Vuelve a mostrar el formulario con los errores
    }

    try {
        
        usuarioService.registrarUsuario(usuario);
        // Comenta estas líneas temporalmente
        // Authentication authentication = new UsernamePasswordAuthenticationToken(usuario.getDni(), usuario.getContraseña());
        // Authentication authenticatedUser = authenticationManager.authenticate(authentication);
        // SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
        return "redirect:/loginUsuario?registrationSuccess"; // Redirige a login con un mensaje de éxito
        } catch (IllegalArgumentException e) {
        model.addAttribute("errorRegistro", e.getMessage());
        model.addAttribute("usuario", usuario);
        return "RegistroUsuario";
        }
}
}