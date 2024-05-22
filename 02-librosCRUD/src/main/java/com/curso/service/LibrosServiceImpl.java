package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.model.Libro;

@Service
public class LibrosServiceImpl implements LibrosService {

	List<Libro> libros;
	
	public LibrosServiceImpl() {
		libros = new ArrayList<>();
		libros.add(new Libro(111,"Grecia","viajes"));
		libros.add(new Libro(222,"Crimen en el parque","novela negra"));
		libros.add(new Libro(333,"Java21","programación"));
		libros.add(new Libro(444,"Verano en Hawai","poesia"));
		libros.add(new Libro(555,"Italia","viajes"));
	}
	@Override
	public List<Libro> libros() {
		return libros;
	}

	@Override
	public Libro buscarLibro(int isbn) {
		
		return libros
				.stream()
				.filter(l->l.getIsbn()==isbn)
				.findFirst()
				.orElse(null);
	}

	@Override
	public void altaLibro(Libro libro) {
		libros.add(libro);
	}

	@Override
	public void actualizarLibro(Libro libro) {
		Libro lib = buscarLibro(libro.getIsbn());
		if (lib!=null) {
			lib.setTematica(libro.getTematica());
			lib.setTitulo(libro.getTitulo());
		}

	}

	@Override
	public List<Libro> eliminarLibro(int isbn) {
		libros.removeIf(l->l.getIsbn()==isbn);
		return libros;
	}

}
