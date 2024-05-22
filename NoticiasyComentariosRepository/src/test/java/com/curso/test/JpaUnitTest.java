package com.curso.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class JpaUnitTest {
	
	static EntityManagerFactory emf;
	protected EntityManager em;
	
	@BeforeAll
   static void setupStaticTest() {
	   Persistence.generateSchema("noticias", null);
	   emf = Persistence.createEntityManagerFactory("noticias");
   }
	
	@BeforeEach
	void setupTest() {
		em=emf.createEntityManager();
	}

	@AfterEach
	void downTest() {
		em.clear();
		em.close();
	}
	@AfterAll
	static void downStaticTest() {
		emf.close();
	}
	
}
