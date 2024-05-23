package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer> {

}
