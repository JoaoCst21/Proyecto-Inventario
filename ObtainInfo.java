package com.joao.controlador;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ObtainInfo {

	public String next() {
		String texto=null;
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));		
		try{		
			texto=bf.readLine();		
		}catch(IOException ioe){
			System.out.println("Error de IOE");	
			System.exit(0);			
		}		
		return texto;
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public char nextChar() {
		System.out.println("se Tomara en cuenta la Primer letra de la Palabra ingresada");
		return (next().charAt(0));
	}

	public Double nextDouble() {
		return Double.parseDouble(next());
	}
}