package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Ejemplar;

@Service
public class EjemplaresServiceImpl implements EjemplaresService {

	@Autowired
	RestTemplate template;
	
	private String url = "http://localhost:8080/libros";
	
	@Override
	public List<Ejemplar> nuevoEjemplar(Ejemplar ejemplar) {
		//http://localhost:8080/libros --> url + "libros" 
		template.postForLocation(url , ejemplar);     //http://localhost:8080/libros | POST en 02-librosCRUD
		return Arrays.asList((template.getForObject(url , Ejemplar[].class)));    //http://localhost:8080/libros | GET en 02-librosCRUD
	}

	
}
