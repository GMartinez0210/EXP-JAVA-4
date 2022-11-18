package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import beans.CarritoDTO;
import beans.DetalleCarrito_DTO;
import beans.Usuario_DTO;
import interfaces.Carrito_DAO;
import utils.MySQLConexion;

public class MySQL_CarritoDAO implements Carrito_DAO{

	public List<CarritoDTO> listarCarritoXCod(int id) {
		CarritoDTO obj = null;
		List<CarritoDTO> data = new ArrayList<CarritoDTO>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySQLConexion.getConexion();
			String sql = "call ListarCarrito(?);";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new CarritoDTO();
				obj.setId(rs.getInt(1));
				obj.setNomUsu(rs.getString(2));
				obj.setImg(rs.getBinaryStream(3));
				obj.setMarcaProd(rs.getString(4));
				obj.setNomProd(rs.getString(5));
				obj.setPrecioProd(rs.getDouble(6));
				obj.setCantProd(rs.getInt(7));
				obj.setTotalProd(rs.getDouble(8));
				data.add(obj);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

	public void listarImg(int id, HttpServletResponse response){
		Connection con;
		PreparedStatement pstm;
		ResultSet rs;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			String sql = "SELECT * FROM producto where id = 1;";
			outputStream = response.getOutputStream();
			con = MySQLConexion.getConexion();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			response.setContentType("image/*");
			if(rs.next()) {
				inputStream = rs.getBinaryStream("image");
			}
			bufferedInputStream = new BufferedInputStream(inputStream);
			bufferedOutputStream = new BufferedOutputStream(outputStream);
			int i  = 0;
			while((i = bufferedInputStream.read()) != 1) {
				System.out.println(i);
				bufferedOutputStream.write(i);
			}
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	@Override
	public int AgregarACarrito(Usuario_DTO usuario_DTO) {
		int det = -1;
		Connection con = null;
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		try {
			con = MySQLConexion.getConexion();
			con.setAutoCommit(false);
			String sql1 = "call exp_java_4.BuscarCarrito(?);";
			pstm1 = con.prepareStatement(sql1);
			pstm1.setInt(1, usuario_DTO.getId());
			
			//String sql2 = 
			
		}
		catch(Exception e) {
			System.out.println("Error en la instrucción SQL: " + e.getMessage());
			try {
				con.rollback();
			} 
			catch (Exception e2) {
				System.out.println("Error en el rollback(): " + e.getMessage());
			}
		}
		return det;
	}
}
