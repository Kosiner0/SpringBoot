package com.curso.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Noticia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String titulo;
	private String autor;
	private LocalDate fecha;
		
	@OneToMany(mappedBy="noticia", cascade=CascadeType.ALL)
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
	public Noticia() {
		super();
	}
	
	
	public Noticia(String titulo) {
		super();
		this.titulo = titulo;
	}


	public Noticia(String titulo, String autor, LocalDate fecha) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	
	public List<Comentario> getComentarios() {
		return comentarios;
	}


	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}


	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noticia other = (Noticia) obj;
		return Objects.equals(titulo, other.titulo);
	}
	
	
}
