package interfaces;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import beans.CarritoDTO;
import beans.Usuario_DTO;

public interface Carrito_DAO {
	public List<CarritoDTO> listarCarritoXCod(int id);
	public void listarImg(int id, HttpServletResponse response);
	public int AgregarACarrito(int idUsu, int cantidad);
}
