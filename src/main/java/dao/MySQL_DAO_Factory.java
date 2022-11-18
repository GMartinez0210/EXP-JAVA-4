package dao;

import interfaces.Categoria_Tipo_DAO;
import interfaces.Usuario_DAO;

public class MySQL_DAO_Factory extends DAO_Factory {

	@Override
	public Categoria_Tipo_DAO getTipoUsuario() {
		return new MySQL_TipoUsuario_DAO();
	}

	@Override
	public Categoria_Tipo_DAO getCategoriaProducto() {
		// TODO Auto-generated method stub
		return new MySQL_CategoriaProducto_DAO();
	}

	@Override
	public Usuario_DAO getUsuario() {
		return new MySQL_Usuario_DAO();
	}

}
