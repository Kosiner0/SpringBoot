package com.curso.service;

import java.util.List;

import com.curso.model.Formacion;

public interface FormacionesService {

	List<Formacion> listaFormaciones();
	
	void altaFormacion(Formacion formacion);
}
