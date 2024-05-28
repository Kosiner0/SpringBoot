package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Libro;

public interface LibrosDao extends JpaRepository<Libro, Integer> {

}

