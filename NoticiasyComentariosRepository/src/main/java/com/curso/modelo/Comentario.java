package com.curso.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String texto;
	private String autor;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="noticia_titulo")
	//una noticia tendrá muchos comentarios
	//un comentario pertenece sólo a una noticia
	private Noticia noticia;
	
	
	public Comentario() {
		super();
	}
		
	public Comentario(int id) {
		super();
		this.id = id;
	}

	public Comentario(String texto, String autor, Noticia noticia) {
		super();
		this.texto = texto;
		this.autor = autor;
		this.noticia = noticia;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	public Noticia getNoticia() {
		return noticia;
	}
	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		return id == other.id;
	}
	
	
}
