package waitlingtone.zylphir.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionDAO {
	public static Connection connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","zylphir","Dang0706510020");
			
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	
	public static ResultSet report() throws Exception{
		ResultSet rs = null;
		try {
			Statement statement = connection().createStatement();
			rs = statement.executeQuery("SELECT USERNAME, PASSWORD, FIRST_NAME, LAST_NAME FROM MEMBERS");
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			connection().close();
		}
	}

}
