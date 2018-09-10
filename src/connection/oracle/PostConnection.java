package connection.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Post;

public class PostConnection {

	public static Integer createPost(Post post) throws SQLException{
		String procedure = "{call authenticate_member(?,?,?)}";
		try {
			CallableStatement callable = ConnectionDAO.connection().prepareCall(procedure);
			callable.setString(1, post.getTitle());
			callable.setString(2, post.getContent());
			callable.registerOutParameter(3, java.sql.Types.INTEGER);
			callable.executeUpdate();
			int rs_int = callable.getInt(3);
			return rs_int;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			ConnectionDAO.connection().close();
		}
	}
	public static ResultSet getListPost(Integer memberId) throws SQLException{
		ResultSet rs;
		String query = "SELECT TITLE, CONTENT, IMAGE, UPDATE_AT FROM POST WHERE POST.MEMBERID = ?";
		try {
			PreparedStatement stmt = ConnectionDAO.connection().prepareStatement(query);
			stmt.setInt(1, memberId);
			rs = stmt.executeQuery();
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnectionDAO.connection().close();
		}
	}
}
