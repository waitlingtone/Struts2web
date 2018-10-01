package connection.oracle;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberConnection {
	public static ResultSet getInformationMember(Integer memberID) throws SQLException{
		String query = "SELECT * FROM MEMBER where id = ?";
		ResultSet rs;
		try {
			PreparedStatement stmt = ConnectionDAO.connection().prepareStatement(query);
			stmt.setInt(1, memberID);
			rs = stmt.executeQuery();
			return rs;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnectionDAO.connection().close();
		}
	}
	public static ResultSet searchMemberByName(String name) throws SQLException{
		String procedure = "{ call proc_searchMemberByName(?,?)}";
		ResultSet rs;
		try {
			CallableStatement callable = ConnectionDAO.connection().prepareCall(procedure);
			callable.setString(1, name);
			callable.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			callable.executeQuery();
			rs = (ResultSet) callable.getObject(2);
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnectionDAO.connection().close();
		}
	}
}
