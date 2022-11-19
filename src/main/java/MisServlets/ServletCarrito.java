package MisServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		int id = 1;
		System.out.println(id);
		mysqlCarritoDAO.listarImg(id, null);
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
		if (xtipo.equals("listarxCod")) {
			listarxCod(request, response);
		}
		//Código para agregar a carrito 
		else if (xtipo.equalsIgnoreCase("AgregarACarritoXCod")) {
			agregarACarritoXCod(request, response);
		}
	}

	private void agregarACarritoXCod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
		int cantidad, idProd;
		System.out.println("Revisar si el front-end tiene el parámetro de cantidad y que el parámetro id de Producto sea 'idProd'");
		cantidad = Integer.parseInt(request.getParameter("cantidad"));
		idProd = Integer.parseInt(request.getParameter("idProd"));
		
		HttpSession sesion = request.getSession(true);
		System.out.println(cantidad + " " + idProd);
	}

	private void listarxCod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviceCarrito.listaCarritoXCod(Integer.parseInt(request.getParameter("idUsu"))));
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
}
