package services;

import java.util.ArrayList;

import beans.ListProd;
import dao.DAO_Factory;
import interfaces.Producto_Interface_DAO;

public class Producto_Service {
	DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
	
	Producto_Interface_DAO producto = fabrica.getProductoInterface();

	public ArrayList<ListProd> listar_Categoria(int id) {
		return producto.listarCategoria(id);
	}
	
	ListProd mostrar(int id) {
		return producto.mostrar(id);
	}
}
