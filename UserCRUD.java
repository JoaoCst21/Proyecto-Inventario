package com.joao.controlador;
import java.util.ArrayList;
import com.joao.modelo.Usuario;
import com.joao.controlador.ControladorUser;
import com.joao.controlador.ObtainInfo;

public class UserCRUD{
	ControladorUser cUser = new ControladorUser();
	ArrayList<Usuario> usuarios = cUser.getUsuarios();
	ObtainInfo sc = new ObtainInfo();

	// Create
	public void agregar(String correo, String contrasenia, char rol) {
		usuarios.add(new Usuario(correo, contrasenia, rol));
		System.out.println("Datos Procesados");
	}

	// Read
	public void reporte() {
		for (Usuario user : usuarios) {
			System.out.println("Correo: " + user.getEmail());
			System.out.println("rol: " + user.getRol());
		}
	}

	public void reporte(Usuario user) {
		System.out.println("Correo: " + user.getEmail());
		System.out.println("Contraseña: " + user.getPassword());
		System.out.println("rol: " + user.getRol());
	}

	// Update
	public boolean modificarEmail(String correo) {
		for(Usuario user : usuarios)
			if (user.getEmail().equals(correo)) {
				System.out.println("Usuario encontrado");
				while (true) {
					System.out.println("agrega el nuevo correo");
					String newCorreo = sc.next();
					if (cUser.verificarNewEmail(newCorreo) && isSure(user)) {
						user.setEmail(newCorreo);
						System.out.println("Datos Procesados");
						return true;
					}
					System.out.println("Algo salio mal!");
					if (!tryAgain()) return false;
				}
			}
		System.out.println("no se encontro el correo");
		return false;
	}

	public boolean modificarPassword(String correo) {
		for(Usuario user : usuarios)
			if (user.getEmail().equals(correo)) {
				System.out.println("Usuario encontrado");
				System.out.println("agrega la nueva contraseña");
				String newPassword = sc.next();
				if (!isSure(user)) return false;
				user.setEmail(newPassword);
				System.out.println("Datos Procesados");
				return true;
			}
		System.out.println("no se encontro el correo");
		return false;
	}

	public boolean modificarRol(String correo) {
		for(Usuario user : usuarios)
			if (user.getEmail().equals(correo)) {
				System.out.println("Usuario encontrado");
				while (true) {
					System.out.println("agrega el nuevo rol");
					char newRol = sc.nextChar();
					if (cUser.verificarRol(newRol) && isSure(user)) {
						user.setRol(newRol);
						System.out.println("Datos Procesados");
						return true;
					}
					System.out.println("Algo salio mal!");
					if (!tryAgain()) return false;
				}
			}
		System.out.println("no se encontro el correo");
		return false;
	}

	// Delete
	public boolean eliminar(String correo ) {
		for (Usuario user : usuarios)
			if (user.getEmail().equals(correo)) {
				System.out.println("Correo Encontrado");
				if (!isSure(user)) return false;
				usuarios.remove(user);
				System.out.println("datos Procesados");
				System.out.println("asi ha quedado la base de datos de Usuarios");
				reporte();
				return true;
			}
		System.out.println("no se ha encontrado el correo");
		return false;
	}

	// Private Methods
	private boolean tryAgain() {
		System.out.println("Desea intentar de nuevo? si/no?");
		if (sc.next().toLowerCase().equals("si")) return true;
		return false;
	}

	private boolean isSure(Usuario user) {
		System.out.println("Esta seguro que desea eliminar/modificar estos datos?");
		reporte(user);
		System.out.println("\nSeguro? si/no?");
		if (sc.next().toLowerCase().equals("si")) return true;
		return false;
	}
}