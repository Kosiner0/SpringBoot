package com.curso.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Propietario {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPropietario;
	private String nombre;
	private String profesion;
	private int edad;
	
	@OneToMany(mappedBy="propietario", cascade=CascadeType.ALL)
	private List<Coche> coches = new ArrayList<Coche>();
	
	public Propietario() {
		super();
	}

	public Propietario(int idPropietario) {
		super();
		this.idPropietario = idPropietario;
	}

	public Propietario(String nombre, String profesion, int edad) {
		super();
		this.nombre = nombre;
		this.profesion = profesion;
		this.edad = edad;
	}

	public int getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<Coche> getCoches() {
		return coches;
	}

	public void setCoches(List<Coche> coches) {
		this.coches = coches;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPropietario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propietario other = (Propietario) obj;
		return idPropietario == other.idPropietario;
	}

	@Override
	public String toString() {
		return "Propietario [idPropietario=" + idPropietario + ", nombre=" + nombre + ", profesion=" + profesion
				+ ", edad=" + edad + "]";
	}
	
}
