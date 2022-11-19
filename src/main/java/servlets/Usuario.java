package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario_DTO;
import services.Usuario_Service;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Usuario_Service usuarioService = new Usuario_Service();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario() {
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
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String tipo = req.getParameter("tipo");
		
		if(tipo.equals("agregar")) {
			agregar(req, res);
			return;
		}
		
		if(tipo.equals("listar")) {
			listar(req, res);
			return;
		}
		
		if(tipo.equals("buscar")) {
			buscar(req, res);
			return;
		}
		
		if(tipo.equals("modificar")) {
			modificar(req, res);
			return;
		}
		
		if(tipo.equals("eliminar")) {
			eliminar(req, res);
			return;
		}
	}

	private void agregar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int idTipo = Integer.parseInt(req.getParameter("idTipo"));
		String email = req.getParameter("email");
		String clave = req.getParameter("clave");
		String dni = req.getParameter("dni");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");

		Usuario_DTO usuario = new Usuario_DTO();
		usuario.setIdTipo(idTipo);
		usuario.setEmail(email);
		usuario.setClave(clave);
		usuario.setDni(dni);
		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);
		
		int agregar = usuarioService.agregar(usuario);
		
		boolean error = agregar == -1; 
		
		String mensaje = !error 
				? "Se agregó el usuario con éxito"
				: "Hubo un error al agregar el usuario";
						
		req.setAttribute("error", error);
		req.setAttribute("mensaje", mensaje);
		
		req.getRequestDispatcher("views/usuarioListar.jsp").forward(req, res);
	}
	
	private void listar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("views/usuarioListar.jsp").forward(req, res);
	}
	
	private void buscar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Usuario_DTO usuario = usuarioService.buscar(id);
		req.setAttribute("usuario", usuario);
		req.getRequestDispatcher("views/usuarioListar.jsp").forward(req, res);
	}
	
	private void modificar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int idTipo = Integer.parseInt(req.getParameter("idTipo"));
		String email = req.getParameter("email");
		String clave = req.getParameter("clave");
		String dni = req.getParameter("dni");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");

		Usuario_DTO usuario = new Usuario_DTO();
		usuario.setId(id);
		usuario.setIdTipo(idTipo);
		usuario.setEmail(email);
		usuario.setClave(clave);
		usuario.setDni(dni);
		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);
		
		int modificar = usuarioService.modificar(usuario);
		
		boolean error = modificar == -1; 
		
		String mensaje = !error 
				? "Se modificó el usuario con éxito"
				: "Hubo un error al modificar el usuario";
						
		req.setAttribute("error", error);
		req.setAttribute("mensaje", mensaje);
		
		req.getRequestDispatcher("views/usuarioListar.jsp").forward(req, res);
	}

	private void eliminar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		int eliminar = usuarioService.eliminar(id);
		
		boolean error = eliminar == -1; 
		
		String mensaje = !error 
				? "Se eliminó el usuario con éxito"
				: "Hubo un error al eliminar el usuario";
						
		req.setAttribute("error", error);
		req.setAttribute("mensaje", mensaje);
		
		req.getRequestDispatcher("views/usuarioListar.jsp").forward(req, res);	
	}

}
