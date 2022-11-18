package services;

import java.util.List;

import beans.CarritoDTO;
import dao.DAO_Factory;
import interfaces.Carrito_DAO;
import utils.Constantes;

public class CarritoService {

	DAO_Factory fabrica = DAO_Factory.getDAO_Factory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	Carrito_DAO objCarrito = fabrica.getCarrito();
	
	public List<CarritoDTO> listaCarritoXCod(int codUsu){
		System.out.println("Llegó al Service");
		return objCarrito.listarCarritoXCod(codUsu);
	}
}
