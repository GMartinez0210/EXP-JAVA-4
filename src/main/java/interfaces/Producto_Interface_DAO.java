package interfaces;

import beans.Producto;

public interface Producto_Interface_DAO {
	public int registrar(Producto p);
	
	public int actualizar(Producto p);
	
	public int eliminar(Producto p);
	
	public Producto buscar(String codigo);
	
	
}
