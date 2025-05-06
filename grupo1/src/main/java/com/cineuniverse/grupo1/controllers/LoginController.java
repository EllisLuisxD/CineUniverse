package com.cineuniverse.grupo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
    @GetMapping("/loginUsuario")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        if (error != null) {
            model.addAttribute("error", "DNI o contraseña inválidos.");
        }
        if (logout != null) {
            model.addAttribute("logout", "Has cerrado sesión exitosamente.");
        }
        return "LoginUsuario";
    }
}
