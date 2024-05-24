package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.Coche;
import com.curso.service.CochesService;

@RestController
public class CochesController {

	@Autowired
	CochesService service;
	
	@GetMapping(value="coches", produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<Coche> buscarCoches(){
		 return service.coches();
	 }
	
	@GetMapping(value="coche/{numBastidor}", produces=MediaType.APPLICATION_JSON_VALUE)
	 public Coche buscarCoche(@PathVariable int numBastidor){
		 return service.buscarCoche(numBastidor);
	 }
	
	@PostMapping(value="coches", consumes=MediaType.APPLICATION_JSON_VALUE)
	 public List<Coche> altaCoche(@RequestBody Coche coche){
		 return service.altaCoche(coche);
	 }
	
	@DeleteMapping(value="coches/{numBastidor}", produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<Coche> eliminarCoche(@PathVariable int numBastidor){
		 return service.eliminarCoche(numBastidor);
	 }
	
	@GetMapping(value="coches/{marca}", produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<Coche> cochesPorMarca(@PathVariable String marca){
		 return service.cochesPorMarca(marca);
	 }
	
	@GetMapping(value="coche/{precioMin}/{precioMax}", produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<Coche> cochesPorPrecioEntre(@PathVariable("precioMin") Double precioMin, @PathVariable("precioMax") Double precioMax){
		 return service.cochesPorPrecioEntre(precioMin, precioMax);
	 }
	
	@GetMapping(value="coches/{marca}/{modelo}", produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<Coche> cochesPorMarcaModelo(@PathVariable("marca") String marca, @PathVariable("modelo") String modelo){
		 return service.cochesPorMarcaModelo(marca, modelo);
	 }
	
}
