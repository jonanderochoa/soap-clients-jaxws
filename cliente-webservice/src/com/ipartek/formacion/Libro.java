package com.ipartek.formacion;

import java.io.Serializable;

public class Libro implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String titulo;
	
	public Libro() {
		super();
		this.codigo = 0;
		this.titulo = "";
	}
	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", titulo=" + titulo + "]";
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
