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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");

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
		
		if(accion.equals("mostrar")) {
			mostrar(request, response);
			return;
		}
	}

	private void mostrar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		DAO_Factory factory = DAO_Factory.getDAO_Factory(1);
		ListProd producto = factory.getProductoInterface().mostrar(id);
		
		req.setAttribute("producto", producto);
		req.getRequestDispatcher("views/homeProducto.jsp").forward(req, res);;
	}
	
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod = request.getParameter("codigo");
		
		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
		Producto p = fabrica.getProductoInterface().buscar(cod);
		
		request.setAttribute("p", p);
		request.getRequestDispatcher("crudProducto.jsp").forward(request, response);
		
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
		ArrayList<ListProd> listado = fabrica.getProductoInterface().listado();
		
		request.setAttribute("lstProducto", listado);
		request.getRequestDispatcher("crudProducto.jsp").forward(request, response);
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("txtCodigo"));
		
		Producto p = new Producto();
		p.setId_prod(cod);
		
		DAO_Factory fabrica = DAO_Factory.getDAO_Factory(DAO_Factory.MYSQL);
		int ok = fabrica.getProductoInterface().eliminar(p);
		
		if (ok == 0) {
			request.setAttribute("mensaje", "<div class='alert alert-danger'role='alert'>"
					+ "Error al eliminar producto " + p.getId_prod() + "! </div>");
		} else {
			request.setAttribute("mensaje", "<div class='alert alert-success'role='alert'>" + "Producto "
					+ p.getId_prod() + " Eliminado! </div>");
		}
		request.getRequestDispatcher("crudProducto.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
		
		if (ok == 0) {
			request.setAttribute("mensaje", "<div class='alert alert-danger'role='alert'>"
					+ "Error al actualizar producto" + p.getId_prod() + "! </div>");
		} else {
			request.setAttribute("mensaje", "<div class='alert alert-success'role='alert'>" + "Producto "
					+ p.getNombre() + " Actualizado! </div>");
		}
		request.getRequestDispatcher("crudProducto.jsp").forward(request, response);
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
		int ok = fabrica.getProductoInterface().registrar(p);
		
		if (ok == 0) {
			request.setAttribute("mensaje", "<div class='alert alert-danger'role='alert'>"
					+ "Error al registrar producto" + p.getId_prod() + "! </div>");
		} else {
			request.setAttribute("mensaje", "<div class='alert alert-success'role='alert'>" + "Producto "
					+ p.getNombre() + " Registrado! </div>");
		}
		request.getRequestDispatcher("crudProducto.jsp").forward(request, response);
		
	}
	

}
