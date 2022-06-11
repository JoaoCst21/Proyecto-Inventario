package com.joao.vista;
import java.util.HashMap;
import com.joao.controlador.ControladorUser;
import com.joao.controlador.ObtainInfo;
import com.joao.controlador.PedirDatos;

public class PantallaPrincipal{
	// java util
	ObtainInfo sc = new ObtainInfo();
	ControladorUser cUser = new ControladorUser();
	PedirDatos ask = new PedirDatos();
	Menu menu = new Menu();
	int option;
	String correo;
	String contrasenia;
	char aceptado;
	HashMap<String, Object> user;


	// Methods
	public void options() {
		System.out.println("1 .... para iniciar sesion");
		System.out.println("2 .... para crear un Usuario");
		option = sc.nextInt();

		if (option == 1) login();
		if (option == 2) createUser();
		System.out.println("Opcion invalida");
	}

	public void login() {
		for (int i = 0; i < 3; i++) {
			user = ask.askUser();

			aceptado = cUser.verificar(user.get("correo").toString(), user.get("contrasenia").toString());
			if (aceptado != 'F') break;
			System.out.println("desea Volver al Menu e intentar luego? si/no?");
			if (sc.next().toLowerCase().equals("si")) {
				aceptado = 'M';
				break;
			}
			else System.out.println("intente de nuevo");
		}
		if (aceptado == 'A') menu.showAdminMenu();
		else if (aceptado == 'B') menu.showMenu();
		else if (aceptado == 'M') options();

		else System.out.println("Te quedaste sin intentos\nEl programa se cerrara ahora");
	}

	public void createUser() {
		boolean aceptado = false;

		while(true) {
			user = ask.askUser();
			aceptado = cUser.verificarNewEmail(user.get("correo").toString());
			if (aceptado) break;
			if (!aceptado) {
				System.out.println("desea Volver al Menu e intentar luego? si/no?");
				if (sc.next().toLowerCase().equals("si")) break;
			}
		}

		if (aceptado) cUser.create(user.get("correo").toString(), user.get("contrasenia").toString(), 'B');
		options();
	}
}