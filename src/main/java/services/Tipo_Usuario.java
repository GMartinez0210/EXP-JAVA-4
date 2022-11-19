package services;

import java.util.ArrayList;

import beans.Categoria_Tipo_DTO;
import dao.DAO_Factory;
import interfaces.Categoria_Tipo_DAO;


public class Tipo_Usuario {
	DAO_Factory factory = DAO_Factory.getDAO_Factory(1);
	
	Categoria_Tipo_DAO tipoUsuario = factory.getTipoUsuario();
	
	public ArrayList<Categoria_Tipo_DTO> listar() {
		return tipoUsuario.listar();
	}
	
}
