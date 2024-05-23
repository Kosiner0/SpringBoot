package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

@RestController
public class CursosController {

	@Autowired
	CursosService service;
	
	@PostMapping(value="cursos", consumes=MediaType.APPLICATION_JSON_VALUE)
	 public List<Curso> altaCurso(@RequestBody Curso curso){
		 return service.altaCurso(curso);
	 }
	
	@DeleteMapping(value="cursos/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<Curso> eliminarCurso(@PathVariable int codCurso){
		 return service.eliminarCurso(codCurso);
	 }
	
	@PutMapping(value="cursos/{codCurso}/{newDuracion}", consumes=MediaType.APPLICATION_JSON_VALUE)
	 public void eliminarCurso(@PathVariable("codCurso") int codCurso, @PathVariable("newDuracion") int newDuracion){
		 service.actualizarDuracion(codCurso, newDuracion);
	 }
	
	@GetMapping(value="cursos/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	 public Curso buscarCurso(@PathVariable int codCurso){
		 return service.buscarCurso(codCurso);
	 }
	
	@GetMapping(value="cursos/{precioMin}/{precioMax}", produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<Curso> eliminarCurso(@PathVariable("precioMin") double precioMin, @PathVariable("precioMax") double precioMax){
		 return service.buscarRangoPrecios(precioMin, precioMax);
	 }
	
}
