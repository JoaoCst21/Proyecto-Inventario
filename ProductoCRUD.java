package com.joao.controlador;
import java.util.ArrayList;
import com.joao.modelo.Producto;
import com.joao.controlador.ControladorProducto;
import com.joao.controlador.ObtainInfo;

public class ProductoCRUD{
	// Attributes
	ControladorProducto cProducto = new ControladorProducto();
	static int idProducto = 2;
	ArrayList<Producto> productos = cProducto.getProductos();
	ObtainInfo sc = new ObtainInfo();

	// Create
	public boolean agregar(String name, String description) {
		idProducto++;
		productos.add(new Producto(name, idProducto, description));
		System.out.println("Datos Procesados\nsu ID es " + idProducto);
		System.out.println("\n\n");
		return true;
	}

	// Read
	public void reporte() {
		for (Producto prod : productos) {
			System.out.println("ID del Producto :" + prod.getIdProducto());
			System.out.println("Nombre del Producto :" + prod.getName());
			System.out.println("Descripcion del Producto :" + prod.getDescription());
		}
		if (productos.size() == 0) System.out.println("No hay Productos!");
		System.out.println("\n\n");
	}

	public void reporte(Producto prod) {
		System.out.println("ID del Producto :" + prod.getIdProducto());
		System.out.println("Nombre del Producto :" + prod.getName());
		System.out.println("Descripcion del Producto :" + prod.getDescription());
	}

	// Update
	public boolean modificarName(int idProducto) {
		for (Producto prod : productos)
			if (prod.getIdProducto() == idProducto) {
				System.out.println("Producto encontrado");
				System.out.println("agrega el nuevo Nombre");
				String name = sc.next();
				if (!isSure(prod)) return false; 
				prod.setName(name);
				System.out.println("Datos Procesados");
				return true;
			}
		System.out.println("Inventario no encontrado");
		return false;
	}

	public boolean modificarDescription(int idProducto) {
		for (Producto prod : productos)
			if (prod.getIdProducto() == idProducto) {
				System.out.println("Producto encontrado");
				System.out.println("ingresa la nueva Descripcion");
				String description = sc.next();
				if (!isSure(prod)) return false; 
				prod.setDescription(description);
				System.out.println("Datos Procesados");
				return true;
				}
		System.out.println("Inventario no encontrado");
		return false;
	}

	// Delete
	public boolean eliminar(int idProducto) {
		for (Producto prod : productos)
			if (prod.getIdProducto() == idProducto) {
				System.out.println("Producto encontrado");
				if (!isSure(prod)) return false; 
				productos.remove(prod);
				System.out.println("Datos Procesados");
				return true;
				}
		System.out.println("Inventario no encontrado");
		return false;
	}

	// Private
	private boolean isSure(Producto prod) {
		System.out.println("Esta seguro que desea eliminar/modificar estos datos?");
		reporte(prod);
		System.out.println("\nSeguro? si/no?");
		if (sc.next().toLowerCase().equals("si")) return true;
		return false;
	}
}