package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.curso.modelo.Noticia;
import com.curso.repositorio.jpa.NoticiaRepositoryJpa;

class NoticiaRepositoryTest extends JpaUnitTest {
	NoticiaRepositoryJpa repositorio;
	
	@BeforeEach
	public void setup() {
		super.setupTest();
		repositorio=new NoticiaRepositoryJpa();
		repositorio.setEntityManager(em);
	}
	
	
	@Test
	void inyectarEntityManager() {
		assertEquals(em,repositorio.getEntityManager());
	}

	@Test
	public void seleccionarTodasLasNoticiasTest() {		
		Noticia noticia=repositorio.findAll().iterator().next();
		assertEquals("Por fin lunes",noticia.getTitulo());
	}
	@Test
	public void insertarNoticiaTest() {
		em.getTransaction().begin();
		Noticia noticiaNueva = new Noticia("ya es miercoles", "ana", LocalDate.now());
		repositorio.save(noticiaNueva);
		em.getTransaction().commit();
		Noticia noticia = repositorio.findOne("ya es miercoles");
		assertEquals(noticiaNueva, noticia);
		
	}
	
	
}
