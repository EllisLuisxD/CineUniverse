package com.cineuniverse.grupo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

	
	@GetMapping("/home")
	public String grupo1() {
		return "Index";
	}
}
