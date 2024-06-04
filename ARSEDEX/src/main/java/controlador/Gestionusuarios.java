package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.daousuarios;

/**
 * Servlet implementation class Gestionusuarios
 */
public class Gestionusuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gestionusuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		/**
		 * Apartado del insert
		 */
		String usuario = request.getParameter("usuario");
		String contrasenia = request.getParameter("contrasenia");
		String email = request.getParameter("email");
		int permiso = 1;
		String id = request.getParameter("id");

		usuario a = new usuario(usuario, contrasenia, email, permiso);

		try {
			if(id == "") {
				a.insertar();
			}else {
				
			}

			response.sendRedirect("index.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error de conexion");
		}
		

		
		
		}


}
