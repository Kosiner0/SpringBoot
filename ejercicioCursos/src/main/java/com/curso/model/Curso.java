package com.curso.model;

public class Curso {

	private String nombre;
	private String descripcion;
	private int participantes;
	
	public Curso() {
		super();
	}

	public Curso(String nombre, String descripcion, int participantes) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.participantes = participantes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getParticipantes() {
		return participantes;
	}

	public void setParticipantes(int participantes) {
		this.participantes = participantes;
	}
	
	@Override
	public String toString() {
		return "\nCurso [nombre=" + nombre + ", descripcion=" + descripcion + ", participantes=" + participantes + "]";
	}
}
