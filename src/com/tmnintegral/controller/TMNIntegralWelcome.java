package com.tmnintegral.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class TMNIntegralWelcome {

	@RequestMapping("/login")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>Bienvenido al TMN Integral</h3>"
				+ "Por favor registrese</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
}
