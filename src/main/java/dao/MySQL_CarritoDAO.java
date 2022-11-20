package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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

	public int buscarItem(int idCarrito, int idProducto) {
		int resultado = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "call exp_java_4.BuscarItem(?, ?);";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idCarrito);
			pstm.setInt(2, idProducto);
			pstm.executeQuery();
			resultado = pstm.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	@Override
	public int AgregarACarrito(DetalleCarrito_DTO dc, int idUsu, int idProd, int cantidad) {
		int add = 0;
		int idCarrito = BuscarIDCarrito(idUsu);
		int confirmacion = buscarItem(idCarrito, idProd);
		System.out.println(confirmacion);
		Connection con = null;
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		if(confirmacion == 0) {
			try {
				con = MySQLConexion.getConexion();
				String sql1 = "call exp_java_4.AgregarACarrito(?, ?, ?);";
				pstm1 = con.prepareStatement(sql1);
				pstm1.setInt(1, idCarrito);
				pstm1.setInt(2, idProd);
				pstm1.setInt(3, cantidad);
				add = pstm1.executeUpdate();
				agregarTotal(idUsu);
				}
				catch(Exception e) {
					System.out.println("Error en la instrucción SQL: " + e.getMessage());
				}
		}
		else {
			try {
				System.out.println("Llegó a segundo Try");
				con = MySQLConexion.getConexion();
				String sql2 = "call exp_java_4.SumarACarrito(?, ?, ?)";
				pstm2 = con.prepareStatement(sql2);
				pstm2.setInt(1, cantidad);
				pstm2.setInt(2, idCarrito);
				pstm2.setInt(3, idProd);
				add = pstm2.executeUpdate();
				agregarTotal(idUsu);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return add;
	}
	private void agregarTotal(int idUsu) {
		@SuppressWarnings("unused")
		int estado = 0;
		@SuppressWarnings("unused")
		CarritoDTO c = null;
		double total = 0;
		Connection con = null;
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			con.setAutoCommit(false);
			//Instruccion 1
			String sql1 = "call ListarCarrito(?)";
			pstm1 = con.prepareStatement(sql1);
			pstm1.setInt(1, idUsu);
			rs = pstm1.executeQuery();
			while (rs.next()) {
				c = new CarritoDTO();
				total += (rs.getDouble("PRECIO") * rs.getInt("CANTIDAD"));
			}
			estado = pstm1.executeUpdate();
			
			//Instrucción 2
			String sql2 = "call exp_java_4.AgregarTotal(?, ?);";
			pstm2 = con.prepareStatement(sql2);
			pstm2.setInt(1, idUsu);
			pstm2.setDouble(2, total);
			estado = pstm2.executeUpdate();
			con.commit();
		}
		catch (Exception e) {
			System.out.println("Error al realizar la venta" + e.getMessage());
			try {
				con.rollback();
			}catch (Exception e1) {
				System.out.println("Error al restaurar la Base de Datos" + e1.getMessage());
			}
		}
	}

	@Override
	public int BuscarCarrito(int idUsuario) {
		int resultado = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "call exp_java_4.BuscarCarrito(?);";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idUsuario);
			pstm.executeQuery();
			resultado = pstm.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	public int BuscarIDCarrito(int idUsuario) {
		CarritoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySQLConexion.getConexion();
			String sql = "call BuscarIDCarrito(?);";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, idUsuario);
			rs = pstm.executeQuery();
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

	@Override
	public int eliminarItem(int idCarrito, int idProd, int idUsu) {
		int status = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "call exp_java_4.EliminarItem(?, ?)";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idCarrito);
			pstm.setInt(2, idProd);
			status = pstm.executeUpdate();
			agregarTotal(idUsu);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}
	
	@Override
	public int actualizarItem(int idCarrito, int idProd, int idUsu, int cantidad) {
		int status = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "call exp_java_4.ActualizarItem(?, ?, ?);";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idCarrito);
			pstm.setInt(2, idProd);
			pstm.setInt(3, cantidad);
			status = pstm.executeUpdate();
			agregarTotal(idUsu);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

}