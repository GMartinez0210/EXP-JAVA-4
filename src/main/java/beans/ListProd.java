package beans;

import java.io.InputStream;

public class ListProd {
	private int id_prod;
	private String categoria;
	private String nombre;
	private double precio;
	private int stock;
	private InputStream imagen;
	
	public ListProd() {

	}

	public ListProd(int id_prod, String categoria, String nombre, double precio, int stock, InputStream imagen) {
		this.id_prod = id_prod;
		this.categoria = categoria;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "ListProd [id_prod=" + id_prod + ", categoria=" + categoria + ", nombre=" + nombre + ", precio=" + precio
				+ ", stock=" + stock + ", imagen=" + imagen + "]";
	}

	public int getId_prod() {
		return id_prod;
	}

	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public InputStream getImagen() {
		return imagen;
	}

	public void setImagen(InputStream imagen) {
		this.imagen = imagen;
	}
		
}
