package com.curso.modelo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Coche {

	@Id
	private int numBastidor;
	private String marca;
	private String modelo;
	private int anio;
	private Double precio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="propietario_id")
	private Propietario propietario;
	
	public Coche() {
		super();
	}

	public Coche(int numBastidor, String marca, String modelo, int anio, double precio) {
		super();
		this.numBastidor = numBastidor;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.precio = precio;
	}

	public int getNumBastidor() {
		return numBastidor;
	}

	public void setNumBastidor(int numBastidor) {
		this.numBastidor = numBastidor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Double getPrecio() {
		return precio;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numBastidor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return numBastidor == other.numBastidor;
	}

	@Override
	public String toString() {
		return "Coche [numBastidor=" + numBastidor + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio
				+ ", precio=" + precio + "]";
	}
	
}
