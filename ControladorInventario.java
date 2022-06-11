package com.joao.controlador;
import java.util.ArrayList;
import com.joao.modelo.Inventario;
import com.joao.modelo.Producto;
import com.joao.controlador.ControladorProducto;

public class ControladorInventario{
	static ArrayList<Inventario> inventarios = new ArrayList<Inventario>() {{
		add(new Inventario(1, 1, 100, 2750.00, 1000.00));
		add(new Inventario(2, 2, 100, 2750.00, 1000.00));
	}};

	static int idInventario = 2;
	ControladorProducto cProducto = new ControladorProducto();


	public void addInventario(int idProducto, int stock, Double price, Double cost) {
		boolean aceptado = verificarId(idProducto);
		if (!aceptado) {
			System.out.println("El id es Invalido");
		}
		if (aceptado) {
			idInventario++;
			inventarios.add(new Inventario(idProducto, idInventario, stock, price, cost));
			System.out.println("Datos Procesados\nsu ID es " + idInventario);
			System.out.println("\n\n");
		}
	}

	public void removeInventario(int idProducto, int idInventario) {
		Boolean find = false;
		for (Inventario inv : inventarios) {
			if (inv.getIdProducto() == idProducto && inv.getIdInventario() == idInventario) {
				inventarios.remove(inv);
				System.out.println("inventario eliminado con exito");
				find = true;
				break;
			}
		}
		if (!find) System.out.println("el Inventario no fue encontrado"); 
		System.out.println("\n\n");
	}

	public void reporteInventarios() {
		for (Inventario inv : inventarios) {
			System.out.println("Inventario de "+cProducto.getProductos().get(inv.getIdProducto()-1).getName());
			System.out.println("ID del Producto :"+inv.getIdProducto());
			System.out.println("ID del Inventario :"+inv.getIdInventario());
			System.out.println("Cantidad de Productos :"+inv.getStock());
			System.out.println("Precio del Producto :"+inv.getPrice());
			System.out.println("Costo del Producto :"+inv.getCost());
			System.out.println("\n");
		}
		if (inventarios.size() == 0) System.out.println("No hay Inventarios!");
		System.out.println("\n\n");
	}

	public Boolean verificarId(int idProducto) {
		for (Producto prod : cProducto.getProductos())
			if (prod.getIdProducto() == idProducto) {
				System.out.println("id Valido");
				return true;
			}

		System.out.println("El id es Invalido");
		return false;
	}

	public ArrayList<Inventario> getInventarios() {
		return inventarios;
	}
}