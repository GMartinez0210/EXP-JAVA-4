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
		
		//Código para agregar a carrito 
		
		if (xtipo.equalsIgnoreCase("AgregarACarritoXCod")) {
			agregarACarritoXCod(request, response);
			return;
		}
	}

	private void agregarACarritoXCod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cantidad, idProducto, idUsuario, idCarrito;
		System.out.println("Revisar si el front-end tiene el parámetro de cantidad y que el parámetro id de Producto sea 'idProd'");
		cantidad = Integer.parseInt(request.getParameter("cantidad"));
		idProducto = Integer.parseInt(request.getParameter("idProd"));
		idUsuario = Integer.parseInt(request.getParameter("idUsu"));
		
		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
		fabrica.getCarrito().BuscarCarrito(idUsuario);
		System.out.println("EN SERVLET: " + cantidad + " " + idProducto + " " + idUsuario + " ");
		

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
		
		request.setAttribute("data", serviceCarrito.listaCarritoXCod(Integer.parseInt(request.getParameter("idUsu"))));
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	private void listarxCod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviceCarrito.listaCarritoXCod(Integer.parseInt(request.getParameter("idUsu"))));
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
}
