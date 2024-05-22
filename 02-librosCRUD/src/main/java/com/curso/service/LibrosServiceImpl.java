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
		libros.add(new Libro(111, "Grecia", "viajes"));
		libros.add(new Libro(222, "Crimen en el parque", "novela negra"));
		libros.add(new Libro(333, "Java21", "programación"));
		libros.add(new Libro(444, "Verano en Hawai", "poesia"));
		libros.add(new Libro(555, "Italia", "viajes"));
		
	}
	@Override
	public List<Libro> libros() {
		return libros;
	}

	@Override
	public Libro buscarLibro(int isbn) {
		
		for(Libro lib: libros) {
			if(lib.getIsbn() == isbn) {
				return lib;
			}
		}
		return null;
		
		
		/*
		return libros
				.stream()
				.filter(l -> l.getIsbn() == isbn)
				.findFirst();
				*/
	}

	@Override
	public void altaLibro(Libro libro) {
		libros.add(libro);

	}

	@Override
	public void actualizarLibro(Libro libro) {
		for(Libro lib: libros) {
			if(lib.getIsbn() == libro.getIsbn()) {
				lib.setTitulo(libro.getTitulo());
				lib.setTematica(libro.getTematica());
			}
		}

	}

	@Override
	public List<Libro> eliminarLibro(int isbn) {
		for(Libro lib: libros) {
			if(lib.getIsbn() == isbn) {
				libros.remove(lib);
			}
		}
		return libros;
	}

}
