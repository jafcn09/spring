package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import dao.AulaDAO;
import dao.UsuarioDAO;
import model.Aula;
import model.Usuario;

/**
 * Servlet implementation class UserControler
 */
public class UserControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDAO uDao = new UsuarioDAO(); 
	AulaDAO aDao = new AulaDAO();
	RequestDispatcher rd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControler() {
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
		
		String action = request.getParameter("action");
		
		if(action.equals("login")) {
			login(request, response);
		}
		
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("username");
		String password = DigestUtils.md5Hex(request.getParameter("password"));
		
		HttpSession session = request.getSession();
		
		Usuario logued = uDao.login(usuario, password);
		List<Aula> aulas = aDao.getAulas();
		
		if( logued != null) {
			session.setAttribute("user", logued);
			session.setAttribute("aulas", aulas);
			
			rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
		} else {
			String msg = "Usuario y/o password incorrectos";
			request.setAttribute("message", msg);
			
			rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		
	}

}
