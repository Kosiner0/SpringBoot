package com.curso.service;

import java.util.List;

import com.curso.modelo.Coche;

public interface CochesService {

	List<Coche> coches();
	Coche buscarCoche(int numBastidor);
	List<Coche> altaCoche(Coche coche);
	List<Coche> eliminarCoche(int numBastidor);
	
	List<Coche> cochesPorMarca(String marcaBuscar);
	List<Coche> cochesPorPrecioEntre(Double precioMin, Double precioMax);
	List<Coche> cochesPorMarcaModelo(String marca, String modelo);
	
	List<Coche> cochesEntreAnios(int fechaMin, int fechaMax);
	List<Coche> cochesProfesionPropietario(String profesion);
	List<Coche> cochesPorPropietario(String nombrePropietario);
	List<Coche> cochesAvanzada(String marca, String modelo, Double precioMin, Double precioMax);
	List<Coche> cochesAvanzadaConPropietario(String marca, String profesion, int edadMin);
	
}
