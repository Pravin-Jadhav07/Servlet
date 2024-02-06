import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("dirver registered...");
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/servlet";
		String username = "root";
		String password = "Pravin@123";
		Connection connection = DriverManager.getConnection( url, username, password );
		System.out.println("connection successfull ...");
		return connection;
	}
	
	public static void closeResource(Connection connection,Statement statement ) throws SQLException {
		if ( connection != null )
			connection.close();
		if( statement != null )
			statement.close();
			
	}
}
