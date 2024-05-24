package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.modelo.Coche;

public interface CochesDao extends JpaRepository<Coche, Integer> {

	@Query("SELECT c FROM Coche c WHERE c.marca = :marca")
    List<Coche> cochesPorMarca(@Param("marca") String marcaBuscar);
	
	@Query("SELECT c FROM Coche c WHERE c.precio BETWEEN :precioMin AND :precioMax")
    List<Coche> cochesPorPrecioEntre(@Param("precioMin") Double precioMin, @Param("precioMax") Double precioMax);
	
	 @Query("SELECT c FROM Coche c WHERE c.marca = :marca AND c.modelo = :modelo")
	 List<Coche> cochesPorMarcaModelo(@Param("marca") String marca, @Param("modelo") String modelo);

	 
}
