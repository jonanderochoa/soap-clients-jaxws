package com.ipartek.formacion;

import java.io.Serializable;

public class Provincia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nombre;
	
	public Provincia() {
		super();
		this.codigo = 00;
		this.nombre = "";
	}

	@Override
	public String toString() {
		return "Provincia [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
