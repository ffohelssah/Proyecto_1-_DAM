package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.usuario;

import java.io.IOException;
import java.net.http.HttpClient;
import java.sql.SQLException;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HttpSession session;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
	 * Apartado de logeo
	 */
		String usuario = request.getParameter("nombre");
		String contrasenia = request.getParameter("contrasenia");
		String email = request.getParameter("email");
		
		usuario u = new usuario();
		u.setEmail(email);
		
		try {
		    if (u.logeo(contrasenia)) {
		        session = request.getSession();
		        session.setAttribute("id", u.getId());
		        session.setAttribute("permiso", u.getPermiso());
		        response.sendRedirect("arboles.html");
		    } else {
		        response.sendRedirect("login.html?error=1");
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		    response.sendRedirect("login.html?error=2");
		}
		
		
		  
		
		
	}

}
