package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursosService {

	List<Curso> cursos();
	Curso buscarCurso(String nombre);
	void altaCurso(Curso Curso);
	void actualizarCurso(Curso Curso);
	List<Curso> eliminarCurso(String nombre);
}
