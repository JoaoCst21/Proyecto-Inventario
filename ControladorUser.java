package com.joao.controlador;
import java.util.ArrayList;
import com.joao.modelo.Usuario;

public class ControladorUser{

	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>() {{
		add(new Usuario("joao123@gmail.com", "123456", 'A'));
		add(new Usuario("david123@gmail.com", "123456", 'A'));
		add(new Usuario("pedro123@gmail.com", "123456", 'B'));
		add(new Usuario("pastor123@gmail.com", "123456", 'B'));
		add(new Usuario("chino123@gmail.com", "123456", 'B'));
	}};

	// Methods
	public char verificar(String correo, String contrasenia) {
		for (Usuario user : usuarios) {
			if (correo.equals(user.getEmail()) && contrasenia.equals(user.getPassword())) {
				System.out.println("Usuario aceptado");
				return user.getRol();
			}
		}

		for (int i = 0; i < correo.length(); i++) {
			if (correo.charAt(i) == '@') {
				System.out.println("Su Correo no esta en nuestra base de datos");
				return 'F';
			}
		}

		System.out.println("Su Correo no fue reconocido como un Correo valido");
		return 'F';
	}



	public Boolean verificarNewEmail(String correo) {
		for (int i = 0; i < correo.length(); i++) {
			if (correo.charAt(i) == '@') {
				System.out.println("Su Correo es valido");
				return true;
			}
		}
		System.out.println("El correo ingresado no tiene @");
		return false;
	}



	public Boolean verificarRol(char rol) {
		if (!(rol == 'A' || rol == 'B')) {
			System.out.println("Rol Invalido");
			return false;
		}
		System.out.println("Rol valido");
		return true;
	}

	public Boolean verificarNewUser(String correo, char rol) {
		if (verificarRol(rol) && verificarNewEmail(correo)) return true;
		return false;
	}



	public void create(String correo, String contrasenia, char rol) {
		usuarios.add(new Usuario(correo, contrasenia, rol));
		System.out.println("Datos Procesados");
	}

	public ArrayList<Usuario> getUsuarios() {
		return this.usuarios;
	}
}

