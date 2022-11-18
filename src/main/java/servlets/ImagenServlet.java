package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO_Factory;

import services.Imagen_service;

/**
 * Servlet implementation class ImagenServlet
 */
@WebServlet(name = "listarImg", urlPatterns = { "/listarImg" })
public class ImagenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Imagen_service imagenService = new Imagen_service();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImagenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
		
		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
		int id = Integer.parseInt(request.getParameter("id"));
		fabrica.getProductoInterface().listarImg(id, response);
//		imagenService.buscar(id, response);
	}

}
