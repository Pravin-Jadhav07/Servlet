

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String message = request.getParameter("message");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/servlet", "root", "Pravin@123");
			 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO registration_table (name,email,password,message)"
					 + "VALUES(?,?,?,?)" );
			 preparedStatement.setString(1, name);
			 preparedStatement.setString(2, email);
			 preparedStatement.setString(3, password);
			 preparedStatement.setString(4, message);
			 
			 int rowsAffected = preparedStatement.executeUpdate();
			 
			 PrintWriter pw = response.getWriter();
			 
			 if( rowsAffected != 0 ) {
				 pw.println("<h1>Registration Successfully.</h1>");
			 }
			 else {
				 pw.println("<h1>Registration failed.</h1>");
			 }
			 preparedStatement.close();
			 connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
