package com.curso.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.DOTCurso;
import com.curso.model.Formacion;

@Service
public class FormacionesServiceImpl implements FormacionesService {

	@Autowired
	RestTemplate template;
	
	private String url = "http://localhost:8080/cursos";
	
	
	@Override
	public List<Formacion> listaFormaciones() {
        DOTCurso[] cursos = template.getForObject(url, DOTCurso[].class);
        return mapCursosToFormaciones(cursos);
    }

	//Si un curso tiene una duración igual o superior a 50 horas, 
	//se considera que tiene 10 asignaturas, sino, serán 5 asignaturas
    private List<Formacion> mapCursosToFormaciones(DOTCurso[] cursos) {
        return Arrays.stream(cursos).map(curso -> {
            int asignaturas = curso.getDuracion() >= 50 ? 10 : 5;
            return new Formacion(curso.getNombre(), asignaturas, curso.getPrecio()); // Precio se puede calcular según sea necesario
        }).collect(Collectors.toList());
    }
	
	
	@Override
	public void altaFormacion(Formacion formacion) {
		DOTCurso curso = new DOTCurso(formacion.getCurso(), (formacion.getAsignaturas() * 10), formacion.getPrecio());
		template.postForLocation(url + "/alta", curso); 
		
	}


}
