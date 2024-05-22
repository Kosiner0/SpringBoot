package com.curso.repositorio;

import com.curso.modelo.Comentario;

public interface ComentarioRepository {
	public Comentario findOne(int numero);
	public Iterable<Comentario> findAll();
	public void save(Comentario comentario);
	public void delete(Comentario comentario);
}
