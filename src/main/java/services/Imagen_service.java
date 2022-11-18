package services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import beans.Producto;
import dao.DAO_Factory;
import interfaces.Producto_Interface_DAO;

public class Imagen_service {
	DAO_Factory factory = DAO_Factory.getDAO_Factory(1);
	
	Producto_Interface_DAO producto = factory.getProductoInterface();
	
	public void buscar(int id, HttpServletResponse response) {
		producto.listarImg(id, response);
	}
}
