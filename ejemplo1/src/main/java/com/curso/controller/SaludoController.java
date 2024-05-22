package com.curso.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Info;

@RestController
public class SaludoController {

	//Get, localhost:8080/saludo
	@GetMapping(value="saludo", produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludar() {
		return "Hola desde Spring :)";
				
	}
	
	
	//Get, localhost:8080/saludo/pepito/grillo --> localhost:8080/saludo/{x}/{y}
	@GetMapping(value="saludo/{x}/{y}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludar(@PathVariable("x") String a, @PathVariable("y") String b) {
		return "Hola desde Spring, " + a + " " + b + ", (hola con parametros 1)";
	}
	
	
	//Get, localhost:8080/saludo2?x=pepito&y=grillo
	@GetMapping(value="saludo2", produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludar2(@RequestParam("x") String a, @RequestParam("y") String b) {
		return "Hola desde Spring, " + a.toUpperCase() + " " + b.toUpperCase() + ", (hola con parametros 2)";
	}
	
	
	//Get, localhost:8080/saludo2Edad?x=pepito&y=19
	@GetMapping(value="saludo2Edad", produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludar2Edad(@RequestParam("x") String a, @RequestParam("y") int b) {
		return "Hola desde Spring, " + a.toUpperCase() + ", tienes " + b + " años (hola con parametros 3)";
	}
	
	
	//Get, localhost:8080/infoCliente
	@GetMapping(value="infoCliente", produces=MediaType.APPLICATION_JSON_VALUE)
	public Info informacion() {
		return new Info("Jaimito", 34, "jaimito@false.com");
	}
	
	/*CURSOS
	 * localhost:8080/cursos      			--> GET todos los cursos
	 * localhost:8080/cursos/{id} 			--> GET curso con id proporcionado
	 * localhost:8080/cursos/{id}			--> POST dar de alta el curso con id proporcionado, en el cuerpo paso la info
	 * localhost:8080/cursos/{id}			--> DELETE el curso con id proporcionado
	 * localhost:8080/cursos/{id}			--> PUT actualizar el curso con id proporcionado, en el cuerpo paso la info
	 * 
	 */
}
