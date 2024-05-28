package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursosService {
	
	List<Curso> altaCurso(Curso Curso);
	List<Curso> eliminarCurso(int codCurso);
	void actualizarDuracion(int codCurso, int newDuracion);
	Curso buscarCurso(int codCurso);
	List<Curso> buscarRangoPrecios(double precioMin, double precioMax);
	List<Curso> listaCursos();

}
