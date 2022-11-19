package MisServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO_Factory;
import dao.MySQL_CarritoDAO;

/**
 * Servlet implementation class ServletCarritoIMG
 */
@WebServlet("/ServletCarritoIMG")
public class ServletCarritoIMG extends HttpServlet {
	MySQL_CarritoDAO mysqlCarritoDAO = new MySQL_CarritoDAO();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCarritoIMG() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
		int id = Integer.parseInt(request.getParameter("id"));
		fabrica.getCarrito().listarImg(id, response);
	}
}
