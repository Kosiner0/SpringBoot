package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.curso.modelo.Noticia;
@TestMethodOrder(OrderAnnotation.class)
class NoticiaTest extends JpaUnitTest{
	
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
	@Order(1)
	void entityManagerFactoryTest() {
		assertNotNull(emf);
	}
	
	@Test
	@Order(2)
	void entiryManagerTest() {
		assertNotNull(em);		
	}
		
	@Test
	@Order(3)
	void seleccionarNoticiaInicialTest() {
		Noticia noticia = em.find(Noticia.class, "Por fin lunes");
		assertEquals("pepito", noticia.getAutor());
	}
	
	@Test
	@Order(4)
	void borrarNoticiaInicialTest() {
		Noticia noticia = em.find(Noticia.class, "Por fin lunes");
		em.getTransaction().begin();
		em.remove(noticia);
		em.getTransaction().commit();
		Noticia sinNoticia = em.find(Noticia.class, "Por fin lunes");		
		assertNull(sinNoticia);
	}
	
	@Test
	void insertarNoticiaTest() {
		em.getTransaction().begin();
		Noticia noticiaNueva= new Noticia("Otra noticia", "juanito", LocalDate.now());
		em.persist(noticiaNueva);
		em.getTransaction().commit();
		Noticia noticiaInsertada = em.find(Noticia.class, "Otra noticia");
		assertEquals("Otra noticia", noticiaInsertada.getTitulo());
	}
}
