package dao;

import interfaces.Carrito_DAO;
import interfaces.Categoria_Tipo_DAO;

public abstract class DAO_Factory {
	public static final int MYSQL = 1;
	
	public abstract Categoria_Tipo_DAO getTipoUsuario();
	public abstract Categoria_Tipo_DAO getCategoriaProducto();
	/* Código Alessandro */
	public abstract Carrito_DAO getCarrito();
	
	/* FIN */
	public static DAO_Factory getDAO_Factory(int whichFactory) {
		switch(whichFactory) {
			case MYSQL:
				return new MySQL_DAO_Factory();
			default: 
				return null;
		}
	}
}
