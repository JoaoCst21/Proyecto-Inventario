package com.joao.vista;
import com.joao.Principal;
import com.joao.controlador.PedirDatos;
import com.joao.controlador.Options;
import com.joao.controlador.ControladorUser;

public class Menu{
	// Attributes
	Options call = new Options();
	ControladorUser cUser = new ControladorUser();
	PedirDatos ask = new PedirDatos();

	int option;

	public void showAdminMenu() { 
		while (true) {
			option = ask.askOptions(new String[] {"agregar", "reporte", "eliminar", "agregar usuario", "Salir y cerrar sesion"});

			if (option == 0) call.agregar();
			if (option == 1) call.reporte();
			if (option == 2) call.eliminar();
			if (option == 3) call.newUser();
			if (option == 4) break;
		}
		PantallaPrincipal pPrincipal = new PantallaPrincipal();
		pPrincipal.options();

	}
	public void showMenu() {
		while (true) {
			option = ask.askOptions(new String[] {"agregar", "reporte", "Salir y cerrar sesion"});

			if (option == 0) call.agregar();
			if (option == 1) call.reporte();
			if (option == 2) break;
		}
		PantallaPrincipal pPrincipal = new PantallaPrincipal();
		pPrincipal.options();
	}
}