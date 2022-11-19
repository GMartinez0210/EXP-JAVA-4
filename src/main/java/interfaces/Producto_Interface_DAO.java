package interfaces;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import beans.ListProd;
import beans.Producto;

public interface Producto_Interface_DAO {
	public int registrar(Producto p);
	
	public int actualizar(Producto p);
	
	public int eliminar(int id);
	
	public Producto buscar(int codigo);
	
	public ArrayList<ListProd> listado();
	
	public void listarImg(int id, HttpServletResponse response);
	
	
}
