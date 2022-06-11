package com.joao.controlador;
import java.util.ArrayList;
import com.joao.modelo.Producto;

public class ControladorProducto{
	// Attributes
	static ArrayList<Producto> productos = new ArrayList<Producto>() {{
		add(new Producto("celular", 1, "holaaaaaaaaaaaaaaaaaaaaaaaaaaaaa a a a a  a a a a  a a a  aa  a a a a a a a"));
		add(new Producto("tablet", 2, "jejejeje SIUUUUUUUUUUU"));
	}};
	static int idProducto = 2;

	// Getters
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public Producto getProducto(int idProducto) {
		for (Producto prod : productos)
			if (prod.getIdProducto() == idProducto) return prod;
		return new Producto();
	}

	// Methods
	public void addProducto(String name, String description) {
		idProducto++;
		productos.add(new Producto(name, idProducto, description));
		System.out.println("Datos Procesados\nsu ID es " + idProducto);
		System.out.println("\n\n");
	}

	public void removeProducto(int idProducto) {
		Boolean find = false;

		for (Producto prod : productos) {
			if (prod.getIdProducto() == idProducto) {
				productos.remove(prod);
				System.out.println("Producto eliminado con exito");
				find = true;
				break;
			}
		}
		if (!find) System.out.println("El producto no ha sido encontrado");
		System.out.println("\n\n");
	}

	public void reporteProductos() {
		for (Producto prod : productos) {
			System.out.println("ID del Producto :" + prod.getIdProducto());
			System.out.println("Nombre del Producto :" + prod.getName());
			System.out.println("Descripcion del Producto :" + prod.getDescription());
		}
		if (productos.size() == 0) System.out.println("No hay Productos!");
		System.out.println("\n\n");
	}
}