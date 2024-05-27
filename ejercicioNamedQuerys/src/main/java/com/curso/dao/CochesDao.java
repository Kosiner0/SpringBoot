package com.curso.dao;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.modelo.Coche;

public interface CochesDao extends JpaRepository<Coche, Integer> {

	// Consulta que devuelve una lista de coches de una marca específica.
	@Query("SELECT c FROM Coche c WHERE c.marca = :marca")
	List<Coche> cochesPorMarca(@Param("marca") String marcaBuscar);

	// Consulta que devuelve una lista de coches cuyo precio está entre los valores especificados.
	@Query("SELECT c FROM Coche c WHERE c.precio BETWEEN :precioMin AND :precioMax")
	List<Coche> cochesPorPrecioEntre(@Param("precioMin") Double precioMin, @Param("precioMax") Double precioMax);

	// Consulta que devuelve una lista de coches que coinciden con una marca y un modelo específicos.
	@Query("SELECT c FROM Coche c WHERE c.marca = :marca AND c.modelo = :modelo")
	List<Coche> cochesPorMarcaModelo(@Param("marca") String marca, @Param("modelo") String modelo);

	
	
	
	// Consulta que devuelve una lista de coches cuyo año de fabricación está entre los valores especificados.
	@Query("SELECT c FROM Coche c WHERE c.anio BETWEEN :fechaMin AND :fechaMax")
	List<Coche> cochesEntreAnios(@Param("fechaMin") int fechaMin, @Param("fechaMax") int fechaMax);

	// Consulta para obtener coches por la profesión del propietario
	@Query("SELECT c FROM Coche c WHERE c.propietario.profesion = :profes")
	List<Coche> cochesProfesionPropietario(@Param("profes") String profesion);

	// Consulta para obtener coches por el nombre del propietario
	@Query("SELECT c FROM Coche c WHERE c.propietario.nombre = :propi")
	List<Coche> cochesPorPropietario(@Param("propi") String nombrePropietario);
	
	// Consulta avanzada que devuelve una lista de coches de una marca y modelo específicos,
	// cuyo precio esté dentro de un rango dado, ordenados por año de fabricación en orden descendente
	@Query("SELECT c FROM Coche c WHERE c.marca = :marca AND c.modelo = :modelo AND c.precio BETWEEN :precioMin AND :precioMax ORDER BY c.anio DESC")
	List<Coche> cochesAvanzada(@Param("marca") String marca, 
			@Param("modelo") String modelo, 
			@Param("precioMin") Double precioMin, 
			@Param("precioMax") Double precioMax);
	
	// Consulta avanzada que devuelve una lista de coches de una marca específica,
	// cuyo propietario tenga una profesión específica y una edad mayor a un valor dado. 
	// Los resultados se ordenan por año de fabricación en orden descendente.
	@Query("SELECT c FROM Coche c WHERE c.marca = :marca AND c.propietario.profesion = :profesion "
			+ "AND c.propietario.edad > :edadMin ORDER BY c.anio DESC")
	List<Coche> cochesAvanzadaConPropietario(@Param("marca") String marca,  
			@Param("profesion") String profesion, 
			@Param("edadMin") int edadMin);
	
	
}
