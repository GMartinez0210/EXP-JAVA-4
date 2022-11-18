package MisServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		System.out.println(xtipo);
		if (xtipo.equals("listarxCod")) {
			listarxCod(request, response);
		}
	}

	private void listarxCod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NO OLVIDAR CORREGIR EL SERVLETCARRITO (listarxCod)");
		request.setAttribute("data", serviceCarrito.listaCarritoXCod(1));		
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
}
