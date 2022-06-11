package com.joao.modelo;

public class Usuario{
	String email;
	String password;
	char rol;

	// Constructor
	public Usuario() {}

	public Usuario(String email, String password, char rol) {
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	// Getters
	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public char getRol() {
		return this.rol;
	}


	// Setters
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRol(char rol) {
		this.rol = rol;
	}

}