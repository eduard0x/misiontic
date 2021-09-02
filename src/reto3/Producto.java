package reto3;

public class Producto {
	
	String codigo;
	double precio_compra;
	double precio_venta;
	double cantidad_bodega;
	double cantidad_minima;
	boolean IVA;
	
	public Producto(String codigo, double precio_compra, double precio_venta, double cantidad_bodega, double cantidad_minima,
			boolean iVA) {
		super();
		this.codigo = codigo;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.cantidad_bodega = cantidad_bodega;
		this.cantidad_minima = cantidad_minima;
		IVA = iVA;
	}
	
	public Producto() {
		super();
		this.codigo = "0";
		this.precio_compra = 0;
		this.precio_venta = 0;
		this.cantidad_bodega = 0;
		this.cantidad_minima = 0;
		IVA = true;
	}
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(int precio_compra) {
		this.precio_compra = precio_compra;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(int precio_venta) {
		this.precio_venta = precio_venta;
	}

	public double getCantidad_bodega() {
		return cantidad_bodega;
	}

	public void setCantidad_bodega(int cantidad_bodega) {
		this.cantidad_bodega = cantidad_bodega;
	}

	public double getCantidad_minima() {
		return cantidad_minima;
	}

	public void setCantidad_minima(int cantidad_minima) {
		this.cantidad_minima = cantidad_minima;
	}

	public boolean isIVA() {
		return IVA;
	}

	public void setIVA(boolean iVA) {
		IVA = iVA;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", precio_compra=" + precio_compra + ", precio_venta=" + precio_venta
				+ ", cantidad_bodega=" + cantidad_bodega + ", cantidad_minima=" + cantidad_minima + ", IVA=" + IVA
				+ "]";
	}
	
	

	
}
