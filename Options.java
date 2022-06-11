package com.joao.controlador;
import java.util.HashMap;
import com.joao.controlador.ControladorUser;
import com.joao.controlador.ControladorInventario;
import com.joao.controlador.ControladorProducto;
import com.joao.controlador.ObtainInfo;
import com.joao.controlador.PedirDatos;

public class Options{
	// Util tools
	PedirDatos ask = new PedirDatos();
	ObtainInfo sc = new ObtainInfo();
	ControladorUser cUser = new ControladorUser();
	ControladorInventario cInventario = new ControladorInventario();
	ControladorProducto cProducto = new ControladorProducto();
	String[] options = new String[] {"Inventario", "Producto"};
	HashMap<String, Object> producto;
	HashMap<String, Object> inventario;
	HashMap<String, Object> user;
	int option;

	public void agregar() {
		option = ask.askOptions(options);
		if (option == 0) {
			inventario = ask.askInventario();
			cInventario.addInventario(
				(int)inventario.get("idProducto"),
				(int)inventario.get("stock"),
				(Double)inventario.get("price"),
				(Double)inventario.get("cost")
				);
		}
		if (option == 1) {
			producto = ask.askProducto();
			cProducto.addProducto(producto.get("name").toString(), producto.get("description").toString());
		}
	}

	public void eliminar() {
		option = ask.askOptions(options);
		if (option == 0) {
			inventario = ask.askInventario(true);
			cInventario.removeInventario((int)inventario.get("idProducto"), (int)inventario.get("idInventario"));
		}
		if (option == 1) {
			producto = ask.askProducto(true);
			cProducto.removeProducto((int)producto.get("id"));
		}
	}

	public void reporte() {
		option = ask.askOptions(options);
		if (option == 0) cInventario.reporteInventarios();
		if (option == 1) cProducto.reporteProductos();
	}

	public void newUser() {
		boolean aceptado = false;
		String correo = "";
		char rol = 'X';
		for (int i = 3; i > 0; i--) {
			user = ask.askUser(true);
			correo = user.get("correo").toString();
			rol = user.get("rol").toString().charAt(0);
			aceptado = cUser.verificarNewUser(correo, rol);
			if (aceptado) break;
			System.out.println("Datos Invalidos");
			System.out.println("tienes " + (i-1) + " intentos mas");
			if (i == 1) {
				System.out.println("se te han acabado los intentos");
				break;
			}
			System.out.println("desea Volver al Menu e intentar luego? si/no?");
			if (sc.next().toLowerCase().equals("si")) break;
			}
		if (aceptado) cUser.create(correo, user.get("contrasenia").toString(), rol);
	}
}