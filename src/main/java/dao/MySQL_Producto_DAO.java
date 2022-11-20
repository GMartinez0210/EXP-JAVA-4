package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import beans.ListProd;
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
			pst.setBlob(6, p.getImage());

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
			pst.setBlob(5, p.getImage());
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

	@Override
	public ArrayList<ListProd> listado() {
		ArrayList<ListProd> listado = new ArrayList<ListProd>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion.getConexion();
			String sql = "call proc_listarProd()";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();
			
			while (rs.next()) {
				ListProd p = new ListProd();
				p.setId_prod(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setPrecio(rs.getDouble(3));
				p.setStock(rs.getInt(4));
				p.setCategoria(rs.getString(5));
				p.setImagen(rs.getBinaryStream(6));
				listado.add(p);
			}
			
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return listado;
	}

	@Override
	public void listarImg(int id, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		
		
		try {
			outputStream = response.getOutputStream();
			con = MySQLConexion.getConexion();
			String sql = "call proc_listimg(?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			response.setContentType("image/*");
			
			if(rs.next()) {
				inputStream = rs.getBinaryStream("image");
			}
			bufferedInputStream = new BufferedInputStream(inputStream);
			bufferedOutputStream = new BufferedOutputStream(outputStream);
			int i = 0;
			while ((i = bufferedInputStream.read()) != -1) {
				bufferedOutputStream.write(i);
			}
		} catch (Exception e) {
			System.out.println("Error en listado de imagen: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		
	}

	@Override
	public ArrayList<ListProd> listarCategoria(int idCategoria) {
		ArrayList<ListProd> listado = new ArrayList<ListProd>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion.getConexion();
			String sql = "call USP_ListarProducto_Home(?);";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, idCategoria);
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				ListProd p = new ListProd();
				p.setId_prod(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setPrecio(rs.getDouble(3));
				p.setStock(rs.getInt(4));
				p.setCategoria(rs.getString(5));
				p.setImagen(rs.getBinaryStream(6));
				listado.add(p);
			}
						
		} catch (Exception e) {
			System.out.println("Error en listado: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return listado;
	}

	@Override
	public ListProd mostrar(int id) {
		ListProd p = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM producto WHERE id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				p.setId_prod(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setPrecio(rs.getDouble(3));
				p.setStock(rs.getInt(4));
				p.setCategoria(rs.getString(5));
				p.setImagen(rs.getBinaryStream(6));
			}
			
		} catch (Exception e) {
			System.out.println("Error en buscar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return p;
	}

}
