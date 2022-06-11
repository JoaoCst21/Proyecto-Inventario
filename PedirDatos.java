package com.joao.controlador;
import java.util.HashMap;
import com.joao.controlador.ObtainInfo;

public class PedirDatos{
	// Attributes
	ObtainInfo sc = new ObtainInfo();
	HashMap<String, Object> props = new HashMap<>();

	// Methods
	// User
	public HashMap<String, Object> askUser() {
		props.clear();
		System.out.println("ingrese su correo");
		props.put("correo", sc.next());
		System.out.println("ingrese sus su contrasenia");
		props.put("contrasenia", sc.next());

		return props;
	}

	public HashMap<String, Object> askUser(boolean isTrue) {
		props.clear();
		System.out.println("ingrese su correo");
		props.put("correo", sc.next());
		System.out.println("ingrese sus su contrasenia");
		props.put("contrasenia", sc.next());
		System.out.println("ingrese su su rol");
		System.out.println("Escoja su Rol\n Escriba A para Admin o B para user normal");
		System.out.println("De escribir mas de una letra se tomara en cuenta la primer letra de la palabra");
		props.put("rol", sc.next());

		return props;
	}


	// Producto
	public HashMap<String, Object> askProducto() {
		props.clear();
		System.out.println("ingrese su nombre");
		props.put("name", sc.next());
		System.out.println("ingrese su descripcion");
		props.put("description", sc.next());

		return props;
	}

	public HashMap<String, Object> askProducto(boolean isTrue) {
		props.clear();
		System.out.println("ingrese el ID del Producto");
		props.put("id", sc.nextInt());

		return props;
	}

	// inventario
	public HashMap<String, Object> askInventario() {
		props.clear();
		System.out.println("ingrese el id del producto con el que enlazar el id");
		props.put("idProducto", sc.nextInt());
		System.out.println("ingrese la cantidad de productos");
		props.put("stock", sc.nextInt());
		System.out.println("ingrese el precio");
		props.put("price", sc.nextDouble());
		System.out.println("ingrese el costo");
		props.put("cost", sc.nextDouble());
		return props;
	}

	public HashMap<String, Object> askInventario(boolean isTrue) {
		props.clear();
		System.out.println("ingrese el ID del Inventario");
		props.put("idInventario", sc.nextInt());
		System.out.println("ingrese el ID del producto al que esta enlazado el inventario");
		props.put("idProducto", sc.nextInt());

		return props;
	}



	// Extra
	public int askOptions(String[] functions) {
		int i = 0;
		for (String x : functions) {
			System.out.println("Presione " + i + " para " + x);
			i++;
		}
		return sc.nextInt();
	}
}

