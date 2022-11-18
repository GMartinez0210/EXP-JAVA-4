package dao;

import interfaces.Categoria_Tipo_DAO;
import interfaces.Producto_Interface_DAO;

public abstract class DAO_Factory {
	public static final int MYSQL = 1;
	
	public abstract Categoria_Tipo_DAO getTipoUsuario();
	public abstract Categoria_Tipo_DAO getCategoriaProducto();
	public abstract Producto_Interface_DAO getProductoInterface();
	
	public static DAO_Factory getDAO_Factory(int whichFactory) {
		switch(whichFactory) {
			case MYSQL:
				return new MySQL_DAO_Factory();
			default: 
				return null;
		}
	}
}
