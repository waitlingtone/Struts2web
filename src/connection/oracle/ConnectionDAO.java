package connection.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionDAO {
	
	private static String orcl_url = "jdbc:oracle:thin:@localhost:1521:db12c";
	private static String orcl_connection_name = "TrongLe";
	private static String orcl_password = "Trong0101";
	public static Connection connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(orcl_url,orcl_connection_name,orcl_password);
			
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	

}
