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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
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
		return this.nombre;
	}

	
	
	
	
	
}
