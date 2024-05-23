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
	CursosService cursos;

	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos() {
		return cursos.cursos();
	}

	@GetMapping(value = "cursos/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable String nombre) {
		return cursos.buscarCurso(nombre);
	}

	@PostMapping(value = "cursos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void curso(@RequestBody Curso curso) {
		cursos.altaCurso(curso);
	}

	@PutMapping(value = "cursos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void cursosPost(@RequestBody Curso nuevoCurso) {
		cursos.actualizarCurso(nuevoCurso);

	}

	@DeleteMapping(value = "cursos/{titulo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursosPut(@PathVariable String nombre) {
		return cursos.eliminarCurso(nombre);

	}

	@GetMapping(value = "curso/{descripcion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarCursoDescripcion(@PathVariable String descripcion) {
		return cursos.buscarPorDescripcion(descripcion);
	}

	@GetMapping(value = "cursos/{min}/{max}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarCursoRangoParticipants(@PathVariable("min") int minPart, @PathVariable("max") int maxPart) {
		return cursos.buscarPorRangoDeParticipantes(minPart, maxPart);
	}

}
