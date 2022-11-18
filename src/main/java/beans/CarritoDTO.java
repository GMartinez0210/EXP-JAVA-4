package beans;

import java.io.InputStream;

public class CarritoDTO {
	private int id, idUsu, cantProd;
	private String NomUsu, marcaProd, nomProd; 
	private double precioProd, totalProd;
	private InputStream img;
	public CarritoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarritoDTO(int id, int idUsu, int cantProd, String nomUsu, String marcaProd, String nomProd,
			double precioProd, double totalProd, InputStream img) {
		super();
		this.id = id;
		this.idUsu = idUsu;
		this.cantProd = cantProd;
		NomUsu = nomUsu;
		this.marcaProd = marcaProd;
		this.nomProd = nomProd;
		this.precioProd = precioProd;
		this.totalProd = totalProd;
		this.img = img;
	}
	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final int getIdUsu() {
		return idUsu;
	}
	public final void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}
	public final int getCantProd() {
		return cantProd;
	}
	public final void setCantProd(int cantProd) {
		this.cantProd = cantProd;
	}
	public final String getNomUsu() {
		return NomUsu;
	}
	public final void setNomUsu(String nomUsu) {
		NomUsu = nomUsu;
	}
	public final String getMarcaProd() {
		return marcaProd;
	}
	public final void setMarcaProd(String marcaProd) {
		this.marcaProd = marcaProd;
	}
	public final String getNomProd() {
		return nomProd;
	}
	public final void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	public final double getPrecioProd() {
		return precioProd;
	}
	public final void setPrecioProd(double precioProd) {
		this.precioProd = precioProd;
	}
	public final double getTotalProd() {
		return totalProd;
	}
	public final void setTotalProd(double totalProd) {
		this.totalProd = totalProd;
	}
	public final InputStream getImg() {
		return img;
	}
	public final void setImg(InputStream img) {
		this.img = img;
	}
}
