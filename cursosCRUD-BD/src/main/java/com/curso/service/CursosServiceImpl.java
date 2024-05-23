package com.curso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursosDao;
import com.curso.model.Curso;

@Service
public class CursosServiceImpl implements CursosService {

	@Autowired
	CursosDao dao;

	@Override
	public List<Curso> altaCurso(Curso curso) {
		dao.save(curso);
		return dao.findAll();
	}

	@Override
	public List<Curso> eliminarCurso(int codCurso) {
		dao.deleteById(codCurso);
		return dao.findAll();
	}

	@Override
	public void actualizarDuracion(int codCurso, int newDuracion) {
	    Optional<Curso> curso = dao.findById(codCurso);
	    
	    if (curso.isPresent()) {
	        Curso cursoActualizado = curso.get();
	        cursoActualizado.setDuracion(newDuracion);
	        dao.save(cursoActualizado); 
	        
	    } 
	}

	@Override
	public Curso buscarCurso(int codCurso) {
		return dao.findById(codCurso).get();
	}

	@Override
	public List<Curso> buscarRangoPrecios(double precioMin, double precioMax) {
		List<Curso> listaRangoPrecios = new ArrayList<>();
		for(Curso c: dao.findAll()) {
			if(c.getPrecio() >= precioMin && c.getPrecio() <= precioMax) {
				listaRangoPrecios.add(c);
			}
		}
		return listaRangoPrecios;
	}

}
