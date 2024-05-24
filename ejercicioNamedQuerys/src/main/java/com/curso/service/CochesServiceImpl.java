package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CochesDao;
import com.curso.modelo.Coche;

@Service
public class CochesServiceImpl implements CochesService {

	@Autowired
	CochesDao dao;
	
	@Override
	public List<Coche> coches() {
		return dao.findAll();
	}

	@Override
	public Coche buscarCoche(int numBastidor) {
		return dao.findById(numBastidor).get();
	}

	@Override
	public List<Coche> altaCoche(Coche coche) {
		dao.save(coche);
		return dao.findAll();
	}

	@Override
	public List<Coche> eliminarCoche(int numBastidor) {
		dao.delete(dao.findById(numBastidor).get());
		return dao.findAll();
	}

	@Override
	public List<Coche> cochesPorMarca(String marcaBuscar) {
		return dao.cochesPorMarca(marcaBuscar);
	}

	@Override
	public List<Coche> cochesPorPrecioEntre(Double precioMin, Double precioMax) {
		return dao.cochesPorPrecioEntre(precioMin, precioMax);
	}

	@Override
	public List<Coche> cochesPorMarcaModelo(String marca, String modelo) {
		return dao.cochesPorMarcaModelo(marca, modelo);
	}

}
