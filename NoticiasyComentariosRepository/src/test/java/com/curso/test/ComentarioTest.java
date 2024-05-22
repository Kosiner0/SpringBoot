package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.curso.modelo.Comentario;
import com.curso.modelo.Noticia;

class ComentarioTest extends JpaUnitTest{
	/*
	EntityManagerFactory emf;
	EntityManager em;
	
	@BeforeEach
	public void iniciar() {
		Persistence.generateSchema("noticias", null);
		emf=Persistence.createEntityManagerFactory("noticias");
		em= emf.createEntityManager();
	}
	*/
	@Test
	void entityManagerFactoryTest() {
		assertNotNull(emf);
	}
	
	@Test
	void entiryManagerTest() {
		assertNotNull(em);		
	}
	@Test
	void seleccionaComentarioInicialTest() {
		Comentario comentario = em.find(Comentario.class, 1);
		assertEquals("manolito",comentario.getAutor());
	}

	@Test
	void seleccionarComentarioDeNoticaTest() {
		Noticia noticia= em.find(Noticia.class, "Por fin lunes");
		Comentario comentario = noticia.getComentarios().get(0);
		assertEquals("manolito", comentario.getAutor());
	}
	
}
