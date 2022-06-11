package com.joao.modelo;
public class Producto{
	// Attributes
	String name;
	String description;
	int idProducto;

	// Constructor
	public Producto() {}

	public Producto(String name, int idProducto, String description) {
		this.name = name;
		this.description = description;
		this.idProducto = idProducto;
	}

	// Getters
	public int getIdProducto() {
		return this.idProducto;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	// Setters
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}