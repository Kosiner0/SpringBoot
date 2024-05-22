package com.curso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;

@RestController
public class CursosController {
	public static List<Curso> cursos = new ArrayList<Curso>();
	
	//Get, localhost:8080/infoCliente
	@GetMapping(value="random", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso informacionRandom() {
		return new Curso("Jaimito", "jaimito@false.com", 34);
	}
	
	
	//Get, localhost:8080/cursos
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos() {	
		cursos.clear();
		cursos.add(new Curso("Curso1", "Prueba del primer curso", 13));
		cursos.add(new Curso("Curso2", "Prueba del segundo curso", 4));
		cursos.add(new Curso("Curso3", "Prueba del tercer curso", 18));
		cursos.add(new Curso("Prueba", "Prueba random", 15));
		cursos.add(new Curso("Spring Boot", "Curso de especializacion en Spring Boot", 9));
		
		return cursos;
	}
	
	
	@GetMapping(value="cursos/{x}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso curso(@PathVariable("x") String nombre) {	
		for(Curso c: cursos) {
			if(c.getNombre().equals(nombre)) {
				return c;
			}
		}
		
		return null;
	}
	
	
	// Post, localhost:8080/cursos
    @PostMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public String cursosPost(@RequestBody Curso nuevoCurso) {
        if(cursos.add(nuevoCurso)) {
        	return cursos.toString();
        	
        }else {
        	return "El nuevo curso no se ha podido aniadir.";
        }
        
    }
    
    
    @PutMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public String cursosPut(@RequestBody Curso nuevoCurso) {
    	for(Curso c: cursos) {
			if(c.getNombre().equals(nuevoCurso.getNombre())) {
				c.setDescripcion(nuevoCurso.getDescripcion());
				c.setParticipantes(nuevoCurso.getParticipantes());
				return "Actualizado con ecsito";
			}
		}
    	return "No update.";
        
    }
    
    
    
    
    
    
		
}
