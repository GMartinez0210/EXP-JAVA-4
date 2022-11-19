package interfaces;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import beans.CarritoDTO;
import beans.DetalleCarrito_DTO;

public interface Carrito_DAO {
	public List<CarritoDTO> listarCarritoXCod(int id);
	public int AgregarACarrito(DetalleCarrito_DTO detalleCarritoDTO, int idUsu, int idProd, int cantidad);
	public int BuscarCarrito(int idUsu);
}
