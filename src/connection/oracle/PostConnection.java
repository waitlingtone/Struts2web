package connection.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Comment;
import Model.Post;

public class PostConnection {

	public static Integer createPost(Post post) throws SQLException{
		String procedure = "{call proc_insertpost(?,?,?,?,?)}";
		try {
			CallableStatement callable = ConnectionDAO.connection().prepareCall(procedure);
			callable.setInt(1, post.getMemberId());
			callable.setString(2, post.getTitle());
			callable.setString(3, post.getContent());
			callable.setString(4, "/includes/pictures/avatar/defaulavatar.jpg");
			callable.registerOutParameter(5, java.sql.Types.INTEGER);
			callable.executeUpdate();
			int rs_int = callable.getInt(5);
			return rs_int;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			ConnectionDAO.connection().close();
		}
	}
	public static boolean addCommentWithPostId(Comment comment,Integer memberId, Integer postId) throws SQLException{
		String procedure = "{ call proc_insertCommentPost(?,?,?,?)}";
		String out_rs = "FALSE";
		try {
			CallableStatement callable = ConnectionDAO.connection().prepareCall(procedure);
			callable.setInt(1, postId);
			callable.setInt(2, memberId);
			callable.setString(3, comment.getContent());
			callable.setString(4, out_rs);
			callable.registerOutParameter(4, java.sql.Types.VARCHAR);
			callable.executeUpdate();
			out_rs = callable.getString(4);
			if(out_rs.equals("TRUE"))
				return true;
			return false;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		} finally {
			ConnectionDAO.connection().close();
		}
	}
	public static ResultSet getListCommentWithPostId(Integer postId) throws SQLException{
		ResultSet rs;
		String query = "SELECT * FROM COMMENT_POST WHERE COMMENT_POST.POSTID = ? ORDER BY UPDATE_AT ASC";
		try {
			PreparedStatement stmt = ConnectionDAO.connection().prepareStatement(query);
			stmt.setInt(1, postId);
			rs = stmt.executeQuery();
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnectionDAO.connection().close();
		}
	}
	
	public static ResultSet getListPost(Integer memberId) throws SQLException{
		ResultSet rs;
		String query = "SELECT ID,TITLE, CONTENT, IMAGE, UPDATE_AT FROM POST WHERE POST.MEMBERID = ? ORDER BY CREATE_AT DESC";
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
