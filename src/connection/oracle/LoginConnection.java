package connection.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginConnection {
	
	public static boolean Authenticate(String username, String password) throws Exception{
		ResultSet rs = null;
		try {
				PreparedStatement stmt = ConnectionDAO.connection().prepareStatement("SELECT * FROM member WHERE username = ? and password = ?");
				stmt.setString(1,username);
				stmt.setString(2,password);
				rs = stmt.executeQuery();
			return rs.next();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionDAO.connection().close();
		}
	}

	
	public static ResultSet exeQ(String query) throws Exception{
		ResultSet rs = null;
		try {
			Statement statement = ConnectionDAO.connection().createStatement();
			rs = statement.executeQuery(query);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionDAO.connection().close();
		}
	}

}
