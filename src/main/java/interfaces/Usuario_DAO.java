package interfaces;

import java.util.ArrayList;

import beans.Usuario_DTO;

public interface Usuario_DAO {	
	public Usuario_DTO login(String email, String clave);
	
	public int agregar(Usuario_DTO usuario);
	
	public ArrayList<Usuario_DTO> listar();
	public Usuario_DTO buscar(int id);
	
	public int modificar(Usuario_DTO usuario);
	
	public int eliminar(int id);
}
