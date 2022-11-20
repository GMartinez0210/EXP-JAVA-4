package services;

import java.util.List;

import beans.CarritoDTO;
import beans.DetalleCarrito_DTO;
import dao.DAO_Factory;
import interfaces.Carrito_DAO;
import utils.Constantes;

public class CarritoService {

	DAO_Factory fabrica = DAO_Factory.getDAO_Factory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	Carrito_DAO Carrito = fabrica.getCarrito();
	
	public List<CarritoDTO> listaCarritoXCod(int idUsu){
		return Carrito.listarCarritoXCod(idUsu);
	}
	public int agregar(DetalleCarrito_DTO detalleCarrito_DTO, int idUsu, int idProd, int cantidad) {
		return Carrito.AgregarACarrito(detalleCarrito_DTO, idUsu, idProd, cantidad);
	}
	public int eliminarItem(int idCarrito, int idProd, int idUsu){
		return Carrito.eliminarItem(idCarrito, idProd, idUsu);
	}
	public int actualizaItem(int idCarrito, int idProd, int idUsu, int cantidad) {
		return Carrito.actualizarItem(idCarrito, idProd, idUsu, cantidad);
	}
	
	public double[] total_Subtotal_Descuento(int id) {
		return Carrito.total_Subtotal_Descuento(id);
	}
}
