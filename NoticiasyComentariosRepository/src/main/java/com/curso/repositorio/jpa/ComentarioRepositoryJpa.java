package com.curso.repositorio.jpa;

import com.curso.modelo.Comentario;
import com.curso.repositorio.ComentarioRepository;

import jakarta.persistence.EntityManager;

public class ComentarioRepositoryJpa implements ComentarioRepository {
	private EntityManager entityManager;
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Comentario findOne(int numero) {
		return entityManager.find(Comentario.class, numero);
	}

	@Override
	public Iterable<Comentario> findAll() {
		return entityManager.createQuery("SELECT c FROM Comentario c", Comentario.class).getResultList();
	}

	@Override
	public void save(Comentario comentario) {
		entityManager.persist(comentario);

	}

	@Override
	public void delete(Comentario comentario) {
		entityManager.remove(comentario);

	}

}
