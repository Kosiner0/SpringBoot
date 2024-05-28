package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionesService;

@RestController
public class FormacionesController {

	@Autowired
	FormacionesService service;
	
	@GetMapping(value="formaciones", produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<Formacion> listaFormaciones(){
		 return service.listaFormaciones();
	 }
	
	@PostMapping(value="formaciones/alta", consumes=MediaType.APPLICATION_JSON_VALUE)
	void altaEjemplar(@RequestBody Formacion formacion){
		service.altaFormacion(formacion);
	}
	
	
	
}
