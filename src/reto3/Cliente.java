package reto3;

import java.util.ArrayList;
import java.util.Arrays;

public class Cliente {

	String identificacion;
	String nombre;
	String direccion;
	String telefono;
	String correo;
	ArrayList<Cuenta> cuentas;
	
	public Cliente(String identificacion, String nombre, String direccion, String telefono, String correo, ArrayList<Cuenta> cuentas) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.cuentas = cuentas;
	}
	
	public Cliente() {
		this.identificacion = "0";
		this.nombre = "";
		this.direccion = "";
		this.telefono = "";
		this.correo = "";
		this.cuentas = null;
	}
	
	public void realizarPedido() {
		
	}
	
	private boolean dinero_disponible() {
		double dinero = 0;
		for(int i=0; i<cuentas.size();i++) {
			dinero += cuentas.get(i).cantidad_dinero;
		}
		if (dinero>0) {
			return true;
		}
		return false;
	}
	
	public double cuentaMayorDinero() {
		double mayor = 0;
		for(Cuenta a: cuentas) {
			if(a.cantidad_dinero>mayor) {
				mayor = a.cantidad_dinero;
			}
		}
		
		return mayor;
	}

	@Override
	public String toString() {
		return "Cliente [identificacion=" + identificacion + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", correo=" + correo + ", cuentas=" + cuentas + "]";
	}

	
	
	
	
	
}
