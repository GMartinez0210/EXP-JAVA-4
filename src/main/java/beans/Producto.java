package beans;

import java.io.InputStream;

import com.mysql.cj.jdbc.Blob;

public class Producto {
	private int id_prod;
	private int id_categ;
	private String nombre;
	private double precio;
	private int stock;
	private InputStream image;
	
	public Producto() {

	}

	public Producto(int id_prod, int id_categ, String nombre, double precio, int stock, InputStream image) {
		this.id_prod = id_prod;
		this.id_categ = id_categ;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Producto [id_prod=" + id_prod + ", id_categ=" + id_categ + ", nombre=" + nombre + ", precio=" + precio
				+ ", stock=" + stock + ", image=" + image + "]";
	}

	public int getId_prod() {
		return id_prod;
	}

	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}

	public int getId_categ() {
		return id_categ;
	}

	public void setId_categ(int id_categ) {
		this.id_categ = id_categ;
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

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}

}
