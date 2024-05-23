package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.model.Curso;

@Service
public class CursosServiceImpl implements CursosService {

	List<Curso> cursos;
	
	
	public CursosServiceImpl() {
		cursos.add(new Curso("Curso1", "aaa", 15));
		cursos.add(new Curso("Curso2", "bbb", 3));
		cursos.add(new Curso("Curso3", "ccc", 27));
		cursos.add(new Curso("Curso4", "aaa", 9));
		cursos.add(new Curso("Curso5", "ccc", 11));
	}
	
	@Override
	public List<Curso> cursos() {
		return cursos;
	}

	@Override
	public Curso buscarCurso(String nombre) {
		return cursos
				.stream()
				.filter(c->c.getNombre().equals(nombre))
				.findFirst()
				.orElse(null);
	}

	@Override
	public void altaCurso(Curso curso) {
		cursos.add(curso);

	}

	@Override
	public void actualizarCurso(Curso curso) {
		Curso cur = buscarCurso(curso.getNombre());
		if(cur != null) {
			cur.setDescripcion(curso.getDescripcion());
			cur.setParticipantes(curso.getParticipantes());
		}

	}

	@Override
	public List<Curso> eliminarCurso(String nombre) {
		cursos.removeIf(c->c.getNombre().equals(nombre));
		return cursos;
	}

	@Override
	public List<Curso> buscarPorDescripcion(String descripcion) {
		List<Curso> cursosDescrip = new ArrayList<>();
		for(Curso c: cursos) {
			if(c.getDescripcion().equals(descripcion)) {
				cursosDescrip.add(c);
			}
		}
		return cursosDescrip;
	}

	@Override
	public List<Curso> buscarPorRangoDeParticipantes(double partMin, double partMax) {
		List<Curso> cursosRangoPart = new ArrayList<>();
		for(Curso c: cursos) {
			if(c.getParticipantes() >= partMin && c.getParticipantes() <= partMax) {
				cursosRangoPart.add(c);
			}
		}
		return cursosRangoPart;
	}

}
