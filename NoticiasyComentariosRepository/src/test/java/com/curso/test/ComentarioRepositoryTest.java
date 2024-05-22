package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.curso.modelo.Comentario;
import com.curso.repositorio.jpa.ComentarioRepositoryJpa;

class ComentarioRepositoryTest extends JpaUnitTest {
	ComentarioRepositoryJpa repositorio;
	
	@BeforeEach
	public void setup() {
		super.setupTest();
		repositorio=new ComentarioRepositoryJpa();
		repositorio.setEntityManager(em);
	}
	@Test
	void inyectarEntityManager() {
		assertEquals(em,repositorio.getEntityManager());
	}

	@Test
	void seleccionarTodosLosCpmentarios() {
		Comentario comentario = repositorio.findAll().iterator().next();
		assertEquals("manolito", comentario.getAutor());
	}

	@Test
	void seleccionarUnComentario() {
		Comentario comentario=repositorio.findOne(1);
		assertEquals("que bien",comentario.getTexto());
	}
}
