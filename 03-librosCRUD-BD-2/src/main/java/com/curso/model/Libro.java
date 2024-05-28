package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Libro {
	
	@Id
	private int isbn;	
	private String titulo;
	private String tematica;	
	
	public Libro() {
		super();
	}
	public Libro(int isbn, String titulo, String tematica) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.tematica = tematica;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	@Override
	public int hashCode() {
		return Objects.hash(isbn, tematica, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return isbn == other.isbn && Objects.equals(tematica, other.tematica) && Objects.equals(titulo, other.titulo);
	}
	
	
	

}
