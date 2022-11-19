package dao;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
import interfaces.Carrito_DAO;
import utils.MySQLConexion;

public class MySQL_CarritoDAO implements Carrito_DAO{

	@Override
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
				obj.setIdProd(rs.getInt("ID_PRODUCTO"));
				data.add(obj);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

	@Override
	public int AgregarACarrito(DetalleCarrito_DTO dc, int idUsu, int idProd, int cantidad) {
		int add = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			int idCarrito = BuscarIDCarrito(idUsu);
			String sql = "call exp_java_4.AgregarACarrito(?, ?, ?);";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idCarrito);
			pstm.setInt(2, idProd);
			pstm.setInt(3, cantidad);
			add = pstm.executeUpdate();			
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
		return add;
	}
	@Override
	public int BuscarCarrito(int idUsu) {
		int resultado = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql1 = "call exp_java_4.BuscarCarrito(?);";
			pstm = con.prepareStatement(sql1);
			pstm.setInt(1, idUsu);
			pstm.executeQuery();
			resultado = pstm.executeUpdate();
		}
		catch(Exception e) {
			
		}
		return resultado;
	}
	
	public int BuscarIDCarrito(int idUsuario) {
		CarritoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm2 = null;
		ResultSet rs = null;
		try {
			cn = MySQLConexion.getConexion();
			String sql = "call BuscarIDCarrito(?);";
			pstm2 = cn.prepareStatement(sql);
			pstm2.setInt(1, idUsuario);
			rs = pstm2.executeQuery();
			if (rs.next()) {
				obj = new CarritoDTO();
				obj.setId(rs.getInt(1));
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return obj.getId();
		
	}
}