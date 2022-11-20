package interfaces;

import java.util.List;
import beans.CarritoDTO;
import beans.DetalleCarrito_DTO;

public interface Carrito_DAO {
	public List<CarritoDTO> listarCarritoXCod(int id);
	public int AgregarACarrito(DetalleCarrito_DTO detalleCarritoDTO, int idUsu, int idProd, int cantidad);
	public int BuscarCarrito(int idUsu);
	public int eliminarItem(int idCarrito, int idProd, int idUsu);
	public double[] total_Subtotal_Descuento(int id);
	public int sumarItem(int idCarrito, int idProd, int idUsu);
	public int restarItem(int idCarrito, int idProd, int idUsu, int cantidad);
}
