package com.curso.repositorio.jpa;

import com.curso.modelo.Noticia;
import com.curso.repositorio.NoticiaRepository;

import jakarta.persistence.EntityManager;

public class NoticiaRepositoryJpa implements NoticiaRepository {
	private EntityManager entityManager;
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Noticia findOne(String titulo) {
		return entityManager.find(Noticia.class, titulo);
	}

	@Override
	public Iterable<Noticia> findAll() {
		return entityManager.createQuery("SELECT n FROM Noticia n",Noticia.class).getResultList();
	}

	@Override
	public void save(Noticia noticia) {
		entityManager.persist(noticia);

	}

	@Override
	public void delete(Noticia noticia) {
		entityManager.remove(noticia);

	}

}
