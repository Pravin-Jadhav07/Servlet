

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		String password = request.getParameter("password");

		RegistrationModel rmodel = new RegistrationModel();
		rmodel.setName(name);
		rmodel.setEmail(email);
		rmodel.setPassword(password);
		rmodel.setMessage(message);
		 
		int row = rmodel.register();
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		if( row == 0 ) {
			response.sendRedirect("/mvcApp/Failed.jsp");
		}
		else {
			response.sendRedirect("/mvcApp/Success.jsp");
		}
	}

}
