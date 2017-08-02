package authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.jsse.openssl.Authentication;

import database.MySQL;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Auth() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		res.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		
		HttpSession session = req.getSession();
		
		if (user != null && pass != null) {
			MySQL auth = new MySQL();
			if ( auth.Authenticate(user, pass) ) {
				session.setAttribute("user",user);
				res.sendRedirect("welcome.jsp");
			}else {
				res.sendRedirect("login.jsp");
			}
		}else {
			res.sendRedirect("login.jsp");
		}
	}

}
