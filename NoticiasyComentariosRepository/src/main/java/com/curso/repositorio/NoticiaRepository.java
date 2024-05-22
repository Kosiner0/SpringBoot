package com.curso.repositorio;

import com.curso.modelo.Noticia;

public interface NoticiaRepository {
	public Noticia findOne(String titulo);
	public Iterable<Noticia> findAll();
	public void save(Noticia noticia);
	public void delete(Noticia noticia);
}
