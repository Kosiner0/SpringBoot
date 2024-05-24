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
}
