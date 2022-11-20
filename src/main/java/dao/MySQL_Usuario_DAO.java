package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Usuario_DTO;
import interfaces.Usuario_DAO;
import utils.MySQLConexion;

public class MySQL_Usuario_DAO implements Usuario_DAO {

	@Override
	public int agregar(Usuario_DTO usuario) {
		int agregar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String query = "call USP_AgregarUsuario(?,?,?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, usuario.getIdTipo());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getClave());
			preparedStatement.setString(4, usuario.getDni());
			preparedStatement.setString(5, usuario.getNombre());
			preparedStatement.setString(6, usuario.getApellidos());
			
			agregar = preparedStatement.executeUpdate();
			
		}
		catch (Exception e) {
			System.out.println(">>> ERROR en el query: " + e.getMessage());
		}
		finally {
			try {
				if(preparedStatement != null ) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (SQLException e2) {
				System.out.println(">>> ERROR en la BD: " + e2.getMessage());
			}
		}
		
		return agregar;
	}

	@Override
	public ArrayList<Usuario_DTO> listar() {
		ArrayList<Usuario_DTO> usuarios = new ArrayList<Usuario_DTO>();
		
		Usuario_DTO usuario;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String query = "call USP_LeerUsuario();";
			
			preparedStatement = connection.prepareStatement(query);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				usuario = new Usuario_DTO();
				usuario.setId(result.getInt("id"));
				usuario.setTipo(result.getString("tipo"));
				usuario.setEmail(result.getString("email"));
				usuario.setClave(result.getString("clave"));
				usuario.setDni(result.getString("dni"));
				usuario.setNombre(result.getString("nombre"));
				usuario.setApellidos(result.getString("apellidos"));
				
				usuarios.add(usuario);
			}
		}
		catch (Exception e) {
			System.out.println(">>> ERROR en el query: " + e.getMessage());
		}
		finally {
			try {
				if(preparedStatement != null ) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (SQLException e2) {
				System.out.println(">>> ERROR en la BD: " + e2.getMessage());
			}
		}
		
		return usuarios;
	}

	@Override
	public Usuario_DTO buscar(int id) {
		Usuario_DTO usuario = new Usuario_DTO();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String query = "call USP_BuscarUsuario(?);";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			result = preparedStatement.executeQuery();
			
			if(result.next()) {
				usuario.setId(result.getInt("id"));
				usuario.setTipo(result.getString("tipo"));
				usuario.setEmail(result.getString("email"));
				usuario.setClave(result.getString("clave"));
				usuario.setDni(result.getString("dni"));
				usuario.setNombre(result.getString("nombre"));
				usuario.setApellidos(result.getString("apellidos"));
			}
		}
		catch (Exception e) {
			System.out.println(">>> ERROR en el query: " + e.getMessage());
		}
		finally {
			try {
				if(preparedStatement != null ) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (SQLException e2) {
				System.out.println(">>> ERROR en la BD: " + e2.getMessage());
			}
		}
		
		return usuario;
	}

	@Override
	public int modificar(Usuario_DTO usuario) {
		int modificar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String query = "call USP_ModificarUsuario(?,?,?,?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, usuario.getIdTipo());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getClave());
			preparedStatement.setString(4, usuario.getDni());
			preparedStatement.setString(5, usuario.getNombre());
			preparedStatement.setString(6, usuario.getApellidos());
			preparedStatement.setInt(7, usuario.getId());
			
			modificar = preparedStatement.executeUpdate();		
		}
		catch (Exception e) {
			System.out.println(">>> ERROR en el query: " + e.getMessage());
		}
		finally {
			try {
				if(preparedStatement != null ) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (SQLException e2) {
				System.out.println(">>> ERROR en la BD: " + e2.getMessage());
			}
		}
		
		return modificar;
	}

	@Override
	public int eliminar(int id) {
		int eliminar = -1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String query = "call USP_EliminarUsuario(?);";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			
			eliminar = preparedStatement.executeUpdate();	
		}
		catch (Exception e) {
			System.out.println(">>> ERROR en el query: " + e.getMessage());
		}
		finally {
			try {
				if(preparedStatement != null ) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (SQLException e2) {
				System.out.println(">>> ERROR en la BD: " + e2.getMessage());
			}
		}
		
		return eliminar;
	}

	@Override
	public Usuario_DTO login(String email, String clave) {
		Usuario_DTO usuario = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String query = "call USP_LoginUsuario(?,?);";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, clave);
			
			result = preparedStatement.executeQuery();
			
			if(result.next()) {
				usuario = new Usuario_DTO();
				usuario.setId(result.getInt("id"));
				usuario.setTipo(result.getString("tipo"));
				usuario.setEmail(result.getString("email"));
				usuario.setClave(result.getString("clave"));
				usuario.setDni(result.getString("dni"));
				usuario.setNombre(result.getString("nombre"));
				usuario.setApellidos(result.getString("apellidos"));
			}
		}
		catch (Exception e) {
			System.out.println(">>> ERROR en el query: " + e.getMessage());
		}
		finally {
			try {
				if(preparedStatement != null ) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (SQLException e2) {
				System.out.println(">>> ERROR en la BD: " + e2.getMessage());
			}
		}
		
		return usuario;
	}
}
