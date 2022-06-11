package com.joao.controlador;
import java.util.ArrayList;
import com.joao.modelo.Inventario;
import com.joao.modelo.Producto;
import com.joao.controlador.ControladorProducto;
import com.joao.controlador.ControladorInventario;
import com.joao.controlador.ObtainInfo;

public class InventarioCRUD{
	// Atttributes and Util tools
	static int idInventario = 2;
	ControladorInventario cInventario = new ControladorInventario();
	ControladorProducto cProducto = new ControladorProducto();
	ArrayList<Inventario> inventarios = cInventario.getInventarios();
	ObtainInfo sc = new ObtainInfo();

	// Create
	public boolean agregar(int idProducto, int stock, Double price, Double cost) {
		boolean aceptado = cInventario.verificarId(idProducto);
		if (!aceptado) return false;
		idInventario++;
		inventarios.add(new Inventario(idProducto, idInventario, stock, price, cost));
		System.out.println("Datos Procesados\nsu ID es " + idInventario);
		System.out.println("\n\n");
		return true;
	}

	// Read
	public void reporte() {
		for (Inventario inv : inventarios) {
			System.out.println("Inventario de "+cProducto.getProducto(inv.getIdProducto()).getName());
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

	public void reporte(Inventario inv) {
		System.out.println("Inventario de "+cProducto.getProducto(inv.getIdProducto()).getName());
		System.out.println("ID del Producto :"+inv.getIdProducto());
		System.out.println("ID del Inventario :"+inv.getIdInventario());
		System.out.println("Cantidad de Productos :"+inv.getStock());
		System.out.println("Precio del Producto :"+inv.getPrice());
		System.out.println("Costo del Producto :"+inv.getCost());
		System.out.println("\n");
	}

	// Update
	public boolean modificarIdProducto(int idInventario) {
		for (Inventario inv : inventarios)
			if (inv.getIdInventario() == idInventario) {
				System.out.println("Inventario encontrado");
				while (true) {
					System.out.println("agrega el nuevo ID al que se enlazara el producto");
					int idProducto = sc.nextInt();
					if (cInventario.verificarId(idProducto) && isSure(inv)) {
						inv.setIdProducto(idProducto);
						System.out.println("Datos Procesados");
						return true;
					}
					System.out.println("Algo salio mal!");
					if (!tryAgain()) return false;
				}
			}
		System.out.println("Inventario no encontrado");
		return false;
	}


	public boolean modificarStock(int idInventario) {
		for (Inventario inv : inventarios)
			if (inv.getIdInventario() == idInventario) {
				System.out.println("Inventario encontrado");
				System.out.println("agrega la cantidad nueva de stock");
				int stock = sc.nextInt();
				if (!isSure(inv)) return false;
				inv.setStock(stock);
				System.out.println("Datos Procesados");
				return true;
			}
		System.out.println("Inventario no encontrado");
		return false;
	}

	public boolean modificarPrecio(int idInventario) {
		for (Inventario inv : inventarios)
			if (inv.getIdInventario() == idInventario) {
				System.out.println("Inventario encontrado");
				System.out.println("ingresa el nuevo precio");
				Double precio = sc.nextDouble();
				if (!isSure(inv)) return false;
				inv.setPrice(precio);
				System.out.println("Datos Procesados");
				return true;
			}
		System.out.println("Inventario no encontrado");
		return false;
	}
	public boolean modificarCosto(int idInventario) {
		for (Inventario inv : inventarios)
			if (inv.getIdInventario() == idInventario) {
				System.out.println("Inventario encontrado");
				System.out.println("ingresa el nuevo costo");
				Double costo = sc.nextDouble();
				if (!isSure(inv)) return false;
				inv.setCost(costo);
				System.out.println("Datos Procesados");
				return true;
			}
		System.out.println("Inventario no encontrado");
		return false;
	}

	// Delete
	public boolean eliminar(int idInventario) {
		for (Inventario inv : inventarios)
			if (inv.getIdInventario() == idInventario) {
				System.out.println("Inventario encontrado");
				if (!isSure(inv)) return false;
				inventarios.remove(inv);
				System.out.println("Datos Procesados");
				System.out.println("asi ha quedado la base de datos de Usuarios");
				reporte();
				return true;
			}
		System.out.println("Inventario no encontrado");
		return false;
	}

	// Private
	private boolean tryAgain() {
		System.out.println("Desea intentar de nuevo? si/no?");
		if (sc.next().toLowerCase().equals("si")) return true;
		return false;
	}

	private boolean isSure(Inventario inv) {
		System.out.println("Esta seguro que desea eliminar/modificar estos datos?");
		reporte(inv);
		System.out.println("\nSeguro? si/no?");
		if (sc.next().toLowerCase().equals("si")) return true;
		return false;
	}
}