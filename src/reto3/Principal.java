package reto3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {
	
	
	
	
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	static ArrayList<Producto> productos = new ArrayList<Producto>();
	
	static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	
	public  static void main(String[] args) {
		
		mostrarMenu();
		Scanner teclado = new Scanner(System.in);
		
		String input = teclado.next();
		while(Integer.parseInt(input)>0 && Integer.parseInt(input)<16) {
			switch(input) {
			case "1": agregarCliente();
			break;
			case "2": 
				System.out.println("Ingrese el número de identificación del cliente a eliminar: ");
				Scanner teclado2 = new Scanner(System.in);
				String id = teclado2.next();
				eliminarCliente(id);
				
			break;
			case "3":
				System.out.println("Ingrese el número de identificación del cliente a editar: ");
				Scanner teclado3 = new Scanner(System.in);
				String id3 = teclado3.next();
				editarCliente(id3);
				break;
			case "4":
				System.out.println("Ingrese el número de identificación del cliente a buscar: ");
				Scanner teclado4 = new Scanner(System.in);
				String id4 = teclado4.next();
				buscarCliente(id4);
				break;
			case "5":
				listarClientes();
				break;
			case "6":
				agregarProducto();
				break;
			case "7":
				System.out.println("Ingrese el código del producto a eliminar: ");
				Scanner teclado7 = new Scanner(System.in);
				String codigo1 = teclado7.next();
				eliminarProducto(codigo1);
				break;
			case "8":
				System.out.println("Ingrese el código del producto a editar: ");
				Scanner teclado8 = new Scanner(System.in);
				String codigo2 = teclado8.next();
				editarProducto(codigo2);
				break;
			case "9":
				System.out.println("Ingrese el código del producto a buscar: ");
				Scanner teclado9 = new Scanner(System.in);
				String codigo3 = teclado9.next();
				buscarProducto(codigo3);
				
				break;
			case "10":
				realizarPedido();
				
				break;
			case "11":
				listarProductos();
				break;
			case "12":
				listarAprobados();
				break;
			case "13":
				listarRechazados();
				break;
			case "14":
				listarCobrados();
				break;
			case "15":
				listarEntregados();
				break;
			default:
				break;
			}
			
			
			mostrarMenu();
			input = teclado.next();
		}
		
	}
	
	public static void mostrarMenu() {
		
		System.out.println("**** MENU PRINCIPAL ****");
		
		System.out.println("Administración de clientes");
		System.out.println("1. Agregar.");
		System.out.println("2. Eliminar.");
		System.out.println("3. Editar");
		System.out.println("4. Buscar.");
		System.out.println("5. Listar");
		System.out.println();
		System.out.println("Administración de productos");
		System.out.println("6. Agregar.");
		System.out.println("7. Eliminar.");
		System.out.println("8. Editar.");
		System.out.println("9. Buscar.");
		System.out.println("10. Listar.");
		System.out.println();
		System.out.println("Administración de pedidos.");
		System.out.println("11. Realizar pedido");
		System.out.println("12. Listar.");
		System.out.println("13. Pedidos aprobados.");
		System.out.println("14. Pedidos rechazados.");
		System.out.println("15. Pedidos cobrados.");
		System.out.println("16. Pedidos entregados.");
		System.out.println();
			
	}
	
	public static  void agregarCliente() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Identificación");
		String identificacion = teclado.next();
		System.out.println("Nombre");
		String nombre = teclado.next();
		System.out.println("Dirección");
		String direccion = teclado.next();
		System.out.println("Telefono");
		String telefono = teclado.next();
		System.out.println("Correo");
		String correo = teclado.next();
		
		System.out.println("Si tiene cuentas ingrese 1, si no ingrese 2");
		
		int cuenta = teclado.nextInt();
		Cuenta[] cuentas = new Cuenta[0];
		if(cuenta == 1) {
			cuentas = anadirCuentas();
		}
		if(cuenta == 2) {
			
		}
		
		Cliente cliente_nuevo = new Cliente(identificacion, nombre, direccion,telefono, correo, cuentas);
		clientes.add(cliente_nuevo);
		
		
	}
	
	public static Cuenta[] anadirCuentas() {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de cuentas que tiene.");
		int cuentas = teclado.nextInt();
		
		Cuenta[] lista_cuentas = new Cuenta[cuentas];
		for(int i=0;i<cuentas;i++) {
			System.out.println("Ingrese el número de la tarjeta de credito");
			String numero = teclado.next();
			System.out.println("Ingrese el dinero de su cuenta");
			double dinero =teclado.nextDouble();
			lista_cuentas[i] = new Cuenta(numero, dinero);
		
		}
		
		return lista_cuentas;
		
	}
	
	public static void eliminarCliente(String identificacion) {
		for(int i=0;i<clientes.size();i++) {
			if(identificacion == clientes.get(i).identificacion) {
				clientes.remove(i);
			}
		}
	}
	
	public static void editarCliente(String identificacion) {
		for(int i=0;i<clientes.size();i++) {
			if(identificacion == clientes.get(i).identificacion) {
				Scanner teclado = new Scanner(System.in);
				System.out.println("Editar.");
				System.out.println("1. Identificación");
				System.out.println("2. Nombre.");
				System.out.println("3. Dirección.");
				System.out.println("4. Telefono.");
				System.out.println("5. Correo.");
				
				int input = teclado.nextInt();
				switch(input) {
				case 1: 
					System.out.println("Identificación");
					clientes.get(i).identificacion = teclado.next();
				break;
				case 2: 
					System.out.println("Nombre");
					clientes.get(i).nombre = teclado.next();
				break;
				case 3: 
					System.out.println("Dirección");
					clientes.get(i).direccion = teclado.next();
				break;
				case 4: 
					System.out.println("Telefono");
					clientes.get(i).telefono = teclado.next();
				break;
				case 5: 
					System.out.println("Correo");
					clientes.get(i).correo = teclado.next();
				break;
				default:
					System.out.println("Número equivocado.");
				
				}
				
				System.out.println("CAMBIOS GUARDADOS");
				
			}
		}
	}
	
	public static void buscarCliente(String identificacion) {
		boolean existencia = false;
		for(int i=0; i<clientes.size();i++) {
			if(identificacion == clientes.get(i).identificacion) {
				clientes.get(i).toString();
				existencia = true;
			}
		}
		
		if(existencia == false) {
			System.out.println("El cliente no fue encontrado.");
		}
		
		
	}
	
	public static Cliente obtenerCliente(String identificacion) {
		boolean existencia = false;
		for(int i=0; i<clientes.size();i++) {
			if(identificacion == clientes.get(i).identificacion) {
				return clientes.get(i);
				
			}
		}
		
		if(existencia == false) {
			System.out.println("El cliente no fue encontrado.");
		}
		
		return new Cliente();
	}
	public static void listarClientes() {
		
		for(int i = 0; i<clientes.size();i++) {
			clientes.get(i).toString();
		}
	}
	
	
	//Productos
	
	public static void agregarProducto() {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Por favor");
		System.out.println("Ingrese el código del producto");
		String codigo = teclado.next();
		
		System.out.println("Precio de compra");
		int precio_compra = teclado.nextInt();
		
		System.out.println("Precio de venta");
		int precio_venta = teclado.nextInt();
		
		System.out.println("Cantidad en bodega");
		int cantidad_bodega = teclado.nextInt();
		
		System.out.println("Cantidad minima");
		int cantidad_minima = teclado.nextInt();
		
		System.out.println("¿Tiene IVA? SI / NO");
		String iva = teclado.next();
		boolean tieneIva = false;
		if(iva.toUpperCase() == "SI") {
			tieneIva = true;
		}
		
		Producto nuevo_producto = new Producto(codigo, precio_venta, precio_compra, cantidad_bodega, cantidad_minima, tieneIva);
		
		productos.add(nuevo_producto);
	}
	
	public static void eliminarProducto(String codigo) {
		for(int i=0;i<productos.size();i++) {
			if(codigo == productos.get(i).codigo) {
				productos.remove(i);
				System.out.println("Producto eliminado.");
			}
		}
	}
	
	public static void editarProducto(String codigo) {
		for(int i=0;i<productos.size();i++) {
			if(codigo == productos.get(i).codigo) {
				Scanner teclado = new Scanner(System.in);
				System.out.println("Editar.");
				System.out.println("1. Código.");
				System.out.println("2. Precio de compra.");
				System.out.println("3. Precio de venta..");
				System.out.println("4. Cantidad bodega.");
				System.out.println("5. Cantidad minima.");
				
				int input = teclado.nextInt();
				switch(input) {
				case 1: 
					System.out.println("Código");
					productos.get(i).codigo = teclado.next();
				break;
				case 2: 
					System.out.println("Precio de compra");
					productos.get(i).precio_compra = teclado.nextInt();
				break;
				case 3: 
					System.out.println("Precio de venta.");
					productos.get(i).precio_venta = teclado.nextInt();
				break;
				case 4: 
					System.out.println("Cantidad bodega.");
					productos.get(i).cantidad_bodega = teclado.nextInt();
				break;
				case 5: 
					System.out.println("Cantidad minima");
					productos.get(i).cantidad_minima = teclado.nextInt();
				break;
				default:
					System.out.println("Número equivocado.");
				
				}
				
				System.out.println("CAMBIOS GUARDADOS");
				
			}
		}
	
	}
	
	public static void buscarProducto(String codigo) {
		boolean existencia = false;
		for(int i=0; i<productos.size();i++) {
			if(codigo == productos.get(i).codigo) {
				productos.get(i).toString();
				existencia = true;
			}
		}
		
		if(existencia == false) {
			System.out.println("El producto no fue encontrado.");
		}
	}
	
	public static Producto obtenerProducto(String codigo) {
		boolean existencia = false;
		for(int i=0; i<productos.size();i++) {
			if(codigo == productos.get(i).codigo) {
				productos.get(i).toString();
				existencia = true;
				return productos.get(i);
			}
		}
		
		if(existencia == false) {
			System.out.println("El producto no fue encontrado.");
		}
		
		Producto p = new Producto();
		return p;
	}
	
	public static void listarProductos() {
		for(int i = 0; i<productos.size();i++) {
			productos.get(i).toString();
		}
	}
	
	public static void realizarPedido() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese el código de cliente: ");
		System.out.println();
		String codigo_cliente = teclado.next();
		
		Cliente cliente = obtenerCliente(codigo_cliente);
		
		if(cliente.identificacion=="0") {
			System.out.println("Identificación inválida.");
			System.exit(0);
		}
		boolean otro = true;
		
		
		
		HashMap<Producto, Double> subpedidos = new HashMap<Producto, Double>();
		
		String estado_pedido = "Aprobado";
		
		
		while(otro==true) {
			System.out.println("Ingrese el código del producto:");
			System.out.println();
			
			String codigo_producto = teclado.next();
			Producto producto_a_vender = obtenerProducto(codigo_producto);
			
			if(producto_a_vender.codigo != "0") {
				System.out.println();
				System.out.println("Unidades a vender: ");
				double unidades = teclado.nextInt();
				if(producto_a_vender.cantidad_bodega-unidades>=0) {
					subpedidos.put(producto_a_vender, unidades);
					
					
				}else {
					System.out.println("No hay unidades disponibles.");
					estado_pedido = "Rechazado";
				}
				
			}else {
				System.out.println("Ningún producto corresponde al código ingresado.");
				estado_pedido = "Rechazado";
			}
			
		Scanner teclado2 = new Scanner(System.in);
		System.out.println("Desea agregar un producto más a su pedido?");
		System.out.println("1. Si.");
		System.out.println("2. No.");
		String entrada = teclado2.next();
		if(entrada.toLowerCase()=="si") {
			otro = true;
		}else if(entrada.toLowerCase() == "no") {
			otro = false;
		}else {
			System.out.println("Entrada inválida.");
		}
		

		
		
		}
		
		
		
		Pedido nuevo_pedido = new Pedido(cliente,subpedidos,estado_pedido);
		
		pedidos.add(nuevo_pedido);	
	}
	
	
	
	public static void listarPedidos() {
		System.out.println("*******  PEDIDOS ******");
		for(int i = 0; i<pedidos.size();i++) {
			pedidos.get(i).generarInforme();
		}
	}
	
	
	public static void listarAprobados() {
		System.out.println("*******  PEDIDOS APROBADOS  ******");
		for(int i = 0; i<pedidos.size();i++) {
			pedidos.get(i).generarInforme();
		}
	}
	
	
	public static void listarRechazados() {
		System.out.println("*******  PEDIDOS RECHAZADOS  ******");
		for(int i = 0; i<pedidos.size();i++) {
			if(pedidos.get(i).estado=="rechazado") {
				pedidos.get(i).generarInforme();
			}
			
		}
	}
	
	
	public static void listarCobrados() {
		System.out.println("*******  PEDIDOS COBRADOS  ******");
		for(int i = 0; i<pedidos.size();i++) {
			if(pedidos.get(i).estado=="cobrado") {
				pedidos.get(i).generarInforme();
			}
		}
	}
	
	
	public static void listarEntregados() {
		System.out.println("*******  PEDIDOS ENTREGADOS  ******");
		for(int i = 0; i<pedidos.size();i++) {
			if(pedidos.get(i).estado=="entregado") {
				pedidos.get(i).generarInforme();
			}
		}
	}

}
