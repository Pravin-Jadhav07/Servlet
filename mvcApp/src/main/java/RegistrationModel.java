import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationModel {
	
	private String name;
	private String email;
	private String message;
	private String password;
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int register() {
		
		int rowsAffected = 0;
		try {
			connection = JdbcUtil.getConnection();
			String sql = "INSERT INTO registration_table (name,email,password,message) VALUES (?,?,?,?)";
			preparedStatement = connection.prepareStatement( sql );
			preparedStatement.setString(1, name );
			preparedStatement.setString(2, email );
			preparedStatement.setString(3, password );
			preparedStatement.setString(4, message );
			
			rowsAffected = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtil.closeResource(connection, preparedStatement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rowsAffected;
	}
	

}
