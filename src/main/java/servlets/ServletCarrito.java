package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DetalleCarrito_DTO;
import dao.DAO_Factory;
import dao.MySQL_CarritoDAO;
import services.CarritoService;

/**
 * Servlet implementation class ServletCarrito
 */
@WebServlet("/ServletCarrito")
public class ServletCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CarritoService serviceCarrito = new CarritoService();
	MySQL_CarritoDAO mysqlCarritoDAO = new MySQL_CarritoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xtipo = request.getParameter("tipo");
		if (xtipo.equalsIgnoreCase("listarxCod")) {
			listarxCod(request, response);
			return;
		}
		
		if (xtipo.equalsIgnoreCase("AgregarACarritoXCod")) {
			agregarACarritoXCod(request, response);
			return;
		}
		
		if (xtipo.equalsIgnoreCase("EliminarItem")) {
			eliminarItem(request, response);
			return;
		}
		
		if (xtipo.equalsIgnoreCase("ActualizarItem")) {
			actualizarItem(request, response);
			return;
		}
	}

	private void actualizarItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUsu = Integer.parseInt(request.getParameter("idUsu"));
		int idCarrito = (mysqlCarritoDAO.BuscarIDCarrito(idUsu));
		int idProd = Integer.parseInt(request.getParameter("idProd"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		serviceCarrito.actualizaItem(idCarrito, idProd, idUsu, cantidad);
		
		response.sendRedirect("ServletCarrito?tipo=listarxCod&&idUsu="+idUsu);
	}

	private void eliminarItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUsu = Integer.parseInt(request.getParameter("idUsu"));
		int idCarrito = (mysqlCarritoDAO.BuscarIDCarrito(idUsu));
		int idProd = Integer.parseInt(request.getParameter("idProd"));
		serviceCarrito.eliminarItem(idCarrito, idProd, idUsu);
		response.sendRedirect("ServletCarrito?tipo=listarxCod&&idUsu="+idUsu);
	}

	private void agregarACarritoXCod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cantidad, idProducto, idUsuario, idCarrito;
		System.out.println("Revisar si el front-end tiene el parámetro de cantidad y que el parámetro id de Producto sea 'idProd'");
		cantidad = Integer.parseInt(request.getParameter("cantidad"));
		idProducto = Integer.parseInt(request.getParameter("idProd"));
		idUsuario = Integer.parseInt(request.getParameter("idUsu"));
		
		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
		fabrica.getCarrito().BuscarCarrito(idUsuario);
		
		idCarrito = (mysqlCarritoDAO.BuscarIDCarrito(idUsuario));
		DetalleCarrito_DTO dc = new DetalleCarrito_DTO();
		dc.setIdCarrito(idCarrito);
		dc.setIdProducto(idProducto);
		dc.setCantidad(cantidad);
		
		try {
			fabrica.getCarrito().AgregarACarrito(dc, idUsuario, idProducto, cantidad);
		}
		catch(Exception e) {
			System.out.println("ERROR AL AGREGAR A CARRITO" + e.getMessage());
		}
		
		response.sendRedirect("ServletCarrito?tipo=listarxCod&&idUsu="+idUsuario);
	}

	private void listarxCod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviceCarrito.listaCarritoXCod(Integer.parseInt(request.getParameter("idUsu"))));
		request.getRequestDispatcher("views/carritoListar.jsp").forward(request, response);
	}
}
