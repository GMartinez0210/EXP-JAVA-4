package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Producto;
import interfaces.Producto_Interface_DAO;
import utils.MySQLConexion;

public class MySQL_Producto_DAO implements Producto_Interface_DAO {

	@Override
	public int registrar(Producto p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "INSERT INTO producto VALUES (?, ?, ?, ?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, p.getId_prod());
			pst.setInt(2, p.getId_categ());
			pst.setString(3, p.getNombre());
			pst.setDouble(4, p.getPrecio());
			pst.setInt(5, p.getStock());
			pst.setBinaryStream(6, p.getImage());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en registrar:" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int actualizar(Producto p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "UPDATE producto idCategoria = ?, nombre = ?, precio = ?, stock = ?, image = ? WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, p.getId_categ());
			pst.setString(2, p.getNombre());
			pst.setDouble(3, p.getPrecio());
			pst.setInt(4, p.getStock());
			pst.setBinaryStream(5, p.getImage());
			pst.setInt(6, p.getId_prod());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en actualizar:" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int eliminar(Producto p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion.getConexion();
			String sql = "DELETE FROM producto WHERE id =?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, p.getId_prod());
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en eliminar:" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public Producto buscar(String codigo) {
		Producto p = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM producto WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				p = new Producto();
				p.setId_prod(rs.getInt(1));
				p.setId_categ(rs.getInt(2));
				p.setNombre(rs.getString(3));
				p.setPrecio(rs.getDouble(4));
				p.setStock(rs.getInt(5));
				p.setImage(rs.getBinaryStream(6));

			}
			
		} catch (Exception e) {
			System.out.println("Error en buscar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return p;
	}

}
