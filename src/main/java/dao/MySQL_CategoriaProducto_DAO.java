package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Categoria_Tipo_DTO;
import interfaces.Categoria_Tipo_DAO;
import utils.MySQLConexion;

public class MySQL_CategoriaProducto_DAO implements Categoria_Tipo_DAO {

	public ArrayList<Categoria_Tipo_DTO> listar() {
		ArrayList<Categoria_Tipo_DTO> categorias = new ArrayList<Categoria_Tipo_DTO>();
		
		Categoria_Tipo_DTO categoria;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connection = MySQLConexion.getConexion();
			String query = "call USP_LeerCategoriaProducto();";
			
			preparedStatement = connection.prepareStatement(query);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				categoria = new Categoria_Tipo_DTO();
				categoria.setId(result.getInt("id"));
				categoria.setNombre(result.getString("nombre"));
			
				categorias.add(categoria);
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
		
		return categorias;
	}

}
