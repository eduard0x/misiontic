package reto3;

import java.util.HashMap;

public class Pedido {
	
	Cliente cliente;
	HashMap<Producto, Double> subpedidos;
	String estado;
	double total_sin_iva, total_con_iva;
	
	public Pedido(Cliente cliente, HashMap <Producto, Double> lista_subpedidos) {
		super();
		this.cliente = cliente;
		this.subpedidos = lista_subpedidos;
		this.estado = "Aprobado";// aprobados    cobrados entregados.
                this.generarInforme();
		administrar();
	}
	
	public Pedido(Cliente cliente, HashMap <Producto, Double> lista_subpedidos, String estado) {
		super();
		this.cliente = cliente;
		this.subpedidos = lista_subpedidos;
		this.estado = estado.toLowerCase();// aprobados    cobrados entregados.
                this.generarInforme();
		administrar();
	}
	
	public void administrar() {
		if(estado.equals("aprobado")){
			if(cliente.cuentas.size()>0) {
				if(cliente.cuentaMayorDinero()>=total_con_iva) {
					this.estado = "cobrado";
				}else {
					this.estado = "rechazado";
				}
			}else {
				this.estado ="rechazado";
			}
		}else{
                    System.out.println("Rechazado");
                }
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public HashMap<Producto, Double> getSubpedidos() {
		return subpedidos;
	}
	public void setSubpedidos(HashMap<Producto, Double> subpedidos) {
		this.subpedidos = subpedidos;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String generarInforme() {
		String informe = "";
		double total_factura_sin_iva = 0;
		double total_factura_con_iva = 0;
		
		for(int i=0; i<subpedidos.size();i++) {
			Producto producto_a_vender = (Producto) subpedidos.keySet().toArray()[i];
			double unidades = subpedidos.get(producto_a_vender);
			double precio_sin_iva = producto_a_vender.precio_venta;
			double precio_con_iva = precio_sin_iva*(1 + 0.19);
			
			double subtotal_sin= precio_sin_iva*unidades;
			double subtotal_con = precio_con_iva*unidades;
			
			System.out.println(producto_a_vender.codigo);
			System.out.println(unidades);
                        informe += "Subtotal sin IVA: "+subtotal_sin+"\n";
                        informe += "Subtotal con IVA: "+subtotal_con+"\n";
			System.out.println("Subtotal sin IVA: "+subtotal_sin);
			System.out.println("Subtotal con IVA: "+subtotal_con);
			total_factura_sin_iva += subtotal_sin;
			total_factura_con_iva += subtotal_con;	
			
		}
		
		this.total_sin_iva = total_factura_sin_iva;
		this.total_con_iva = total_factura_con_iva;
                
		
                
                informe += "PRECIO TOTAL SIN IVA: "+ total_factura_sin_iva+"\n";
                informe += "PRECIO TOTAL CON IVA: "+ total_factura_con_iva+"\n";
                
		System.out.println("PRECIO TOTAL SIN IVA: "+ total_factura_sin_iva );
		System.out.println("PRECIO TOTAL CON IVA: "+ total_factura_con_iva);
		
                informe += "\n";
		System.out.println();
	
		informe += "Estado: "+estado;
                System.out.println("Estado: "+estado);
                
                return informe;
		
	}

    public double getTotal_sin_iva() {
        return total_sin_iva;
    }

    public void setTotal_sin_iva(double total_sin_iva) {
        this.total_sin_iva = total_sin_iva;
    }

    public double getTotal_con_iva() {
        return total_con_iva;
    }

    public void setTotal_con_iva(double total_con_iva) {
        this.total_con_iva = total_con_iva;
    }
	
	
	
	
	
	
	
	

}
