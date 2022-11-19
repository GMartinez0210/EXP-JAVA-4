package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.ListProd;
import beans.Producto;
import dao.DAO_Factory;

@MultipartConfig
/**
 * Servlet implementation class CrudProductoServlet
 */
@WebServlet(name = "CrudProducto", urlPatterns = { "/CrudProducto" })
public class CrudProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrudProductoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entró al Servlet: CrudProducto");

		String accion = request.getParameter("accion");
		System.out.println("Accion:" + accion);

		if (accion.equals("reg")) {
			registrar(request, response);
			return;
		}

		if (accion.equals("act")) {
			actualizar(request, response);
			return;
		}

		if (accion.equals("eli")) {
			eliminar(request, response);
			return;
		}

		if (accion.equals("lis")) {
			listar(request, response);
			return;
		}

		if (accion.equals("editar")) {
			buscar(request, response);
			return;
		}

	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
		Producto p = fabrica.getProductoInterface().buscar(id);

		request.setAttribute("p", p);
		request.getRequestDispatcher("views/productoListar.jsp").forward(request, response);

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
//		ArrayList<ListProd> listado = fabrica.getProductoInterface().listado();

//		request.setAttribute("lstProducto", listado);
		request.getRequestDispatcher("views/productoListar.jsp").forward(request, response);

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

//		Producto p = new Producto();
//		p.setId_prod(cod);

		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
		int ok = fabrica.getProductoInterface().eliminar(id);

		boolean error = ok == -1;

		String mensaje = !error 
				? "Se elimino el producto con éxito" 
				: "Hubo un error al eliminar el producto";

		request.setAttribute("error", error);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("views/productoListar.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int cod = Integer.parseInt(request.getParameter("txtCodigo"));
		String nombre = request.getParameter("txtNombre");
		double pre = Double.parseDouble(request.getParameter("txtPrecio"));
		int stock = Integer.parseInt(request.getParameter("txtStock"));
		int cat = Integer.parseInt(request.getParameter("cboCategoria"));
		Part img = request.getPart("txtImg");
		InputStream inputstream = img.getInputStream();

		Producto p = new Producto();
		p.setId_prod(cod);
		p.setNombre(nombre);
		p.setPrecio(pre);
		p.setStock(stock);
		p.setId_categ(cat);
		p.setImage(inputstream);

		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
		int ok = fabrica.getProductoInterface().actualizar(p);

		boolean error = ok == -1;

		String mensaje = !error 
				? "Se actualizo el producto con éxito" 
				: "Hubo un error al actualizar el producto";

		request.setAttribute("error", error);
		request.setAttribute("mensaje", mensaje);
		
		request.getRequestDispatcher("views/productoListar.jsp").forward(request, response);

	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
//		int cod = Integer.parseInt(request.getParameter("txtCodigo"));
		String nombre = request.getParameter("txtNombre");
		double pre = Double.parseDouble(request.getParameter("txtPrecio"));
		int stock = Integer.parseInt(request.getParameter("txtStock"));
		int cat = Integer.parseInt(request.getParameter("cboCategoria"));
		Part img = request.getPart("txtImg");
		InputStream inputstream = img.getInputStream();

		Producto p = new Producto();
//		p.setId_prod(cod);
		p.setNombre(nombre);
		p.setPrecio(pre);
		p.setStock(stock);
		p.setId_categ(cat);
		p.setImage(inputstream);

		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
		int ok = fabrica.getProductoInterface().registrar(p);

		boolean error = ok == -1;

		String mensaje = !error 
				? "Se agregó el producto con éxito" 
				: "Hubo un error al agregar el producto";

		request.setAttribute("error", error);
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("views/productoListar.jsp").forward(request, response);

	}

}
