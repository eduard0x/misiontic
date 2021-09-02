package reto3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {
	
	
	
	
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	static ArrayList<Producto> productos = new ArrayList<Producto>();
	
	static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	
	public  static void main(String[] args) {
		
                Tienda ti = new Tienda();
                
		cargarInformacionPrueba();
		mostrarMenu();
		Scanner teclado = new Scanner(System.in);
		
		String input = teclado.next();
		while(Integer.parseInt(input)>0 && Integer.parseInt(input)<16) {
			switch(input) {
			case "1": agregarCliente();
			break;
			case "2": 
				System.out.println("Ingrese el n�mero de identificaci�n del cliente a eliminar: ");
				Scanner teclado2 = new Scanner(System.in);
				String id = teclado2.next();
				eliminarCliente(id);
				
			break;
			case "3":
				System.out.println("Ingrese el n�mero de identificaci�n del cliente a editar: ");
				Scanner teclado3 = new Scanner(System.in);
				String id3 = teclado3.next();
				editarCliente(id3);
				break;
			case "4":
				System.out.println("Ingrese el n�mero de identificaci�n del cliente a buscar: ");
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
				System.out.println("Ingrese el c�digo del producto a eliminar: ");
				Scanner teclado7 = new Scanner(System.in);
				String codigo1 = teclado7.next();
				eliminarProducto(codigo1);
				break;
			case "8":
				System.out.println("Ingrese el c�digo del producto a editar: ");
				Scanner teclado8 = new Scanner(System.in);
				String codigo2 = teclado8.next();
				editarProducto(codigo2);
				break;
			case "9":
				System.out.println("Ingrese el c�digo del producto a buscar: ");
				Scanner teclado9 = new Scanner(System.in);
				String codigo3 = teclado9.next();
				buscarProducto(codigo3);
				
				break;
			case "10":
				listarProductos();
				
				break;
			case "11":
				realizarPedido();
				
				break;
			case "12":
				listarPedidos();
				break;
			case "13":
				listarAprobados();
				break;
			case "14":
				listarRechazados();
				break;
			case "15":
				listarCobrados();
				break;
			case "16":
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
		
		System.out.println("Administraci�n de clientes");
		System.out.println("1. Agregar.");
		System.out.println("2. Eliminar.");
		System.out.println("3. Editar");
		System.out.println("4. Buscar.");
		System.out.println("5. Listar");
		System.out.println();
		System.out.println("Administraci�n de productos");
		System.out.println("6. Agregar.");
		System.out.println("7. Eliminar.");
		System.out.println("8. Editar.");
		System.out.println("9. Buscar.");
		System.out.println("10. Listar.");
		System.out.println();
		System.out.println("Administraci�n de pedidos.");
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
		System.out.println("Identificaci�n");
		String identificacion = teclado.nextLine();
		System.out.println("Nombre");
		String nombre = teclado.nextLine();
		System.out.println("Direcci�n");
		String direccion = teclado.nextLine();
		System.out.println("Telefono");
		String telefono = teclado.nextLine();
		System.out.println("Correo");
		String correo = teclado.nextLine();
		
		System.out.println("Si tiene cuentas ingrese 1, si no ingrese 2");
		
		int cuenta = teclado.nextInt();
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		if(cuenta == 1) {
			cuentas = anadirCuentas();
		}
		if(cuenta == 2) {
			
		}
		
		Cliente cliente_nuevo = new Cliente(identificacion, nombre, direccion,telefono, correo, cuentas);
		clientes.add(cliente_nuevo);
		
		
	}
	
	public static ArrayList<Cuenta> anadirCuentas() {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de cuentas que tiene.");
		int cuentas = teclado.nextInt();
		
		ArrayList<Cuenta> lista =  new ArrayList<Cuenta>();
		for(int i=0;i<cuentas;i++) {
			System.out.println("Ingrese el n�mero de la tarjeta de credito");
			String numero = teclado.next();
			System.out.println("Ingrese el dinero de su cuenta");
			double dinero =teclado.nextDouble();
			lista.add(new Cuenta(numero, dinero));
			
		}
		return lista;
		
	}
	
	public static void eliminarCliente(String identificacion) {
		for(int i=0;i<clientes.size();i++) {
			if(identificacion.equals(clientes.get(i).identificacion)) {
				clientes.remove(i);
				System.out.println("Cliente eliminado");
			}
		}
	}
	
	public static void editarCliente(String identificacion) {
		for(int i=0;i<clientes.size();i++) {
			if(identificacion.equals(clientes.get(i).identificacion)) {
				Scanner teclado = new Scanner(System.in);
				System.out.println("Editar.");
				System.out.println("1. Identificaci�n");
				System.out.println("2. Nombre.");
				System.out.println("3. Direcci�n.");
				System.out.println("4. Telefono.");
				System.out.println("5. Correo.");
				
				int input = teclado.nextInt();
				switch(input) {
				case 1: 
					System.out.println("Identificaci�n");
					clientes.get(i).identificacion = teclado.next();
				break;
				case 2: 
					System.out.println("Nombre");
					clientes.get(i).nombre = teclado.next();
				break;
				case 3: 
					System.out.println("Direcci�n");
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
					System.out.println("N�mero equivocado.");
				
				}
				
				System.out.println("CAMBIOS GUARDADOS");
				
			}
		}
	}
	
	public static void buscarCliente(String identificacion) {
		boolean existencia = false;
		for(int i=0; i<clientes.size();i++) {
			if(identificacion.equals(clientes.get(i).identificacion)) {
				System.out.println(clientes.get(i).toString());
				
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
			if(identificacion.equals(clientes.get(i).identificacion)) {
				return clientes.get(i);
				
			}
		}
		
		if(existencia == false) {
			System.out.println("El cliente no fue encontrado.");
		}
		
		return new Cliente();
	}
	public static void listarClientes() {
		System.out.println("******  CLIENTES  ******");
		for(int i = 0; i<clientes.size();i++) {
			System.out.println(clientes.get(i).toString());
		}
	}
	
	
	//Productos
	
	public static void agregarProducto() {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Por favor");
		System.out.println("Ingrese el c�digo del producto");
		String codigo = teclado.next();
		
		System.out.println("Precio de compra");
		int precio_compra = teclado.nextInt();
		
		System.out.println("Precio de venta");
		int precio_venta = teclado.nextInt();
		
		System.out.println("Cantidad en bodega");
		int cantidad_bodega = teclado.nextInt();
		
		System.out.println("Cantidad minima");
		int cantidad_minima = teclado.nextInt();
		
		System.out.println("�Tiene IVA? SI / NO");
		String iva = teclado.next();
		boolean tieneIva = false;
		if(iva.toUpperCase().equals("SI")) {
			tieneIva = true;
		}
		
		Producto nuevo_producto = new Producto(codigo, precio_venta, precio_compra, cantidad_bodega, cantidad_minima, tieneIva);
		
		productos.add(nuevo_producto);
	}
	
	public static void eliminarProducto(String codigo) {
		for(int i=0;i<productos.size();i++) {
			if(codigo.equals(productos.get(i).codigo)) {
				productos.remove(i);
				System.out.println("Producto eliminado.");
			}
		}
	}
	
	public static void editarProducto(String codigo) {
		for(int i=0;i<productos.size();i++) {
			if(codigo.equals(productos.get(i).codigo)) {
				Scanner teclado = new Scanner(System.in);
				System.out.println("Editar.");
				System.out.println("1. C�digo.");
				System.out.println("2. Precio de compra.");
				System.out.println("3. Precio de venta..");
				System.out.println("4. Cantidad bodega.");
				System.out.println("5. Cantidad minima.");
				
				int input = teclado.nextInt();
				switch(input) {
				case 1: 
					System.out.println("C�digo");
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
					System.out.println("N�mero equivocado.");
				
				}
				
				System.out.println("CAMBIOS GUARDADOS");
				
			}
		}
	
	}
	
	public static void buscarProducto(String codigo) {
		boolean existencia = false;
		for(int i=0; i<productos.size();i++) {
			if(codigo.equals(productos.get(i).codigo)) {
				System.out.println(productos.get(i).toString());
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
			if(codigo.equals(productos.get(i).codigo)) {
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
			System.out.println(productos.get(i).toString());
		}
	}
	
	public static void realizarPedido() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese el c�digo de cliente: ");
		System.out.println();
		String codigo_cliente = teclado.next();
		
		Cliente cliente = obtenerCliente(codigo_cliente);
		
		if(cliente.identificacion=="0") {
			System.out.println("Identificaci�n inv�lida.");
			System.exit(0);
		}
		boolean otro = true;
		
		
		
		HashMap<Producto, Double> subpedidos = new HashMap<Producto, Double>();
		
		String estado_pedido = "Aprobado";
		
		
		while(otro==true) {
			System.out.println("Ingrese el c�digo del producto:");
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
				System.out.println("Ning�n producto corresponde al c�digo ingresado.");
				estado_pedido = "Rechazado";
			}
			
		Scanner teclado2 = new Scanner(System.in);
		System.out.println("Desea agregar un producto m�s a su pedido?");
		System.out.println("Si/No");
		System.out.println();
		String entrada = teclado2.next();
		if(entrada.toLowerCase().equals("si")) {
			otro = true;
		}else if(entrada.toLowerCase().equals("no")) {
			otro = false;
		}else {
			System.out.println("Entrada inv�lida.");
		}
		

		
		
		}
		
		
		
		Pedido nuevo_pedido = new Pedido(cliente,subpedidos,estado_pedido);
		
		pedidos.add(nuevo_pedido);	
		System.out.println("Pedido agregado");
	}
	
	
	
	public static void listarPedidos() {
		System.out.println("*******  PEDIDOS ******");
		for(int i = 0; i<pedidos.size();i++) {
			System.out.println("****    PEDIDO "+(i+1)+"     ******");
			pedidos.get(i).generarInforme();
			System.out.println();
			System.out.println();
		}
	}
	
	
	public static void listarAprobados() {
		System.out.println("*******  PEDIDOS APROBADOS  ******");
		for(int i = 0; i<pedidos.size();i++) {
			
			pedidos.get(i).generarInforme();
			System.out.println();
			System.out.println();
		}
	}
	
	
	public static void listarRechazados() {
		System.out.println("*******  PEDIDOS RECHAZADOS  ******");
		for(int i = 0; i<pedidos.size();i++) {
			if(pedidos.get(i).estado.equals("rechazado")) {
				pedidos.get(i).generarInforme();
				System.out.println();
				System.out.println();
			}
			
		}
	}
	
	
	public static void listarCobrados() {
		System.out.println("*******  PEDIDOS COBRADOS  ******");
		for(int i = 0; i<pedidos.size();i++) {
			if(pedidos.get(i).estado.equals("cobrado")) {
				pedidos.get(i).generarInforme();
				System.out.println();
				System.out.println();
			}
		}
	}
	
	
	public static void listarEntregados() {
		System.out.println("*******  PEDIDOS ENTREGADOS  ******");
		for(int i = 0; i<pedidos.size();i++) {
			if(pedidos.get(i).estado.equals("entregado")) {
				pedidos.get(i).generarInforme();
				System.out.println();
				System.out.println();
			}
		}
	}
	
	public static void cargarInformacionPrueba() {
		
		//Cuentas
		Cuenta cuenta1 = new Cuenta("123",1000);
		Cuenta cuenta2 = new Cuenta("456",10000);
		Cuenta cuenta3 = new Cuenta("789",100000);
		Cuenta cuenta4 = new Cuenta("101",1000000);
		Cuenta cuenta5 = new Cuenta("111",10000000);
		Cuenta cuenta6 = new Cuenta("121",100000000);
		
		//Definici�n de cuentas
		
		ArrayList<Cuenta> cuentas1 = new ArrayList<Cuenta>();
		ArrayList<Cuenta> cuentas2 = new ArrayList<Cuenta>();
		ArrayList<Cuenta> cuentas3 = new ArrayList<Cuenta>();
				
		//Asignaci�n de valores.
		
		cuentas1.add(cuenta1);
		cuentas1.add(cuenta4);
		cuentas1.add(cuenta3);
		
		cuentas2.add(cuenta6);
		
		
		cuentas1.add(cuenta5);
		cuentas1.add(cuenta2);
		
		//Clientes
		
		Cliente c1 = new Cliente("123","Edu","Bog","320","m@g.c",cuentas1);
		Cliente c2 = new Cliente("154","Rib","Cuc","321","n@g.c",cuentas2);
		Cliente c3 = new Cliente("168","Eto","Med","322","mo@g.c",cuentas3);
		Cliente c4 = new Cliente("198","fri","Cal","323","p@g.c",cuentas2);
		Cliente c5 = new Cliente("124","Des","Sol","324","m@g.c",cuentas1);
		
		
		//Productos
		
		Producto p1 = new Producto("1", 2000, 2500, 100, 20, true);
		Producto p2 = new Producto("2", 43100, 44000, 200, 120, true);
		Producto p3 = new Producto("3", 92000, 100000, 10, 2, true);
		Producto p4 = new Producto("4", 73000, 75000, 10, 2, true);
		Producto p5 = new Producto("5", 12000, 15000, 120, 50, true);
		Producto p6 = new Producto("6", 2000, 4000, 120, 20, true);
		Producto p7 = new Producto("7", 62000, 70000, 100, 20, true);
		Producto p8 = new Producto("8", 123000, 130000, 18, 4, true);
		Producto p9 = new Producto("9", 212000, 250000, 14, 4, true);
		Producto p10 = new Producto("10", 12000, 12500, 23, 7, true);
		
		//Subpedidos
		
		HashMap<Producto,Double> subpedidos1 = new HashMap();
			subpedidos1.put(p1, 2.0);
			subpedidos1.put(p2, 20.0);
			subpedidos1.put(p3, 10.0);
			subpedidos1.put(p4, 1.0);
			subpedidos1.put(p5, 12.0);
		
		//Pedidos
		
		Pedido ped1 = new Pedido(c1,subpedidos1);
		
		HashMap<Producto,Double> subpedidos2 = new HashMap();
		subpedidos2.put(p1, 5.0);
		subpedidos2.put(p2, 10.0);
		subpedidos2.put(p5, 1.0);
		subpedidos2.put(p6, 1.0);
		subpedidos2.put(p8, 3.0);
	
		//Pedidos
	
		Pedido ped2 = new Pedido(c2,subpedidos2);
		
		HashMap<Producto,Double> subpedidos3 = new HashMap();
		subpedidos3.put(p4, 5.0);
		subpedidos3.put(p7, 10.0);
		subpedidos3.put(p8, 1.0);
		subpedidos3.put(p9, 1.0);
		subpedidos3.put(p10, 3.0);
	
		//Pedidos
	
		Pedido ped3 = new Pedido(c4,subpedidos3);
		
		//Asignaciones
			//clientes
			clientes.add(c1);
			clientes.add(c2);
			clientes.add(c3);
			clientes.add(c4);
			clientes.add(c5);
		
			//productos
			productos.add(p1);
			productos.add(p2);
			productos.add(p3);
			productos.add(p4);
			productos.add(p5);
			productos.add(p6);
			productos.add(p7);
			productos.add(p8);
			productos.add(p9);
			productos.add(p10);
		
			//pedidos
			
			pedidos.add(ped1);
			pedidos.add(ped2);
			pedidos.add(ped3);
			
		
	
	}

}
