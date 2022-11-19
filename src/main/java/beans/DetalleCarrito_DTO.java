package beans;

public class DetalleCarrito_DTO {
	private int id, idCarrito, idProducto, cantidad;

	public DetalleCarrito_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleCarrito_DTO(int id, int idCarrito, int idProducto, int cantidad) {
		super();
		this.id = id;
		this.idCarrito = idCarrito;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final int getIdCarrito() {
		return idCarrito;
	}

	public final void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public final int getIdProducto() {
		return idProducto;
	}

	public final void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public final int getCantidad() {
		return cantidad;
	}

	public final void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
