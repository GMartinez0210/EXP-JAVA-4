package services;

import java.util.ArrayList;

import beans.Usuario_DTO;
import dao.DAO_Factory;
import interfaces.Usuario_DAO;

public class Usuario_Service {
	DAO_Factory factory = DAO_Factory.getDAO_Factory(1);

	Usuario_DAO usuario = factory.getUsuario();
	
	public Usuario_DTO login(String email, String clave) {
		return usuario.login(email, clave);
	}
	
	public int agregar(Usuario_DTO newUsuario) {
		return usuario.agregar(newUsuario);
	}
	
	public ArrayList<Usuario_DTO> listar() {
		return usuario.listar();
	}
	
	public Usuario_DTO buscar(int id) {
		return usuario.buscar(id);
	}
	
	public int modificar(Usuario_DTO newUsuario) {
		return usuario.modificar(newUsuario);
	}
	
	public int eliminar(int id) {
		return usuario.eliminar(id);
	}
}
