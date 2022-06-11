package com.joao.modelo;
public class Inventario{
	// Attributes
	int idProducto;
	int idInventario;
	int stock;
	Double price;
	Double cost;

	// Constructor
	public Inventario() {}

	public Inventario(int idProducto, int idInventario, int stock, Double price, Double cost) {
		this.idProducto = idProducto;
		this.stock = stock;
		this.idInventario = idInventario;
		this.price = price;
		this.cost = cost;
	}

	// Getters
	public int getIdInventario() {
		return this.idInventario;
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public int getStock() {
		return this.stock;
	}

	public Double getPrice() {
		return this.price;
	}

	public Double getCost() {
		return this.cost;
	}

	// Setters
	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
}