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
		String procedure_insertComment = "{ call proc_insertCommentPost(?,?,?,?)}";
		String out_rs;
		try {
			CallableStatement callable = ConnectionDAO.connection().prepareCall(procedure_insertComment);
			callable.setInt(1, postId);
			callable.setInt(2, memberId);
			callable.setString(3, comment.getContent());
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
		if(postId == null)
			postId = 0;
		String query = "  SELECT COMMENT_POST.ID, COMMENT_POST.CONTENT, COMMENT_POST.MEMBERID, COMMENT_POST.POSTID, COMMENT_POST.CREATE_AT, COMMENT_POST.UPDATE_AT, PROFILE.avatar, MEMBER.FIRST_NAME  || ' ' || MEMBER.LAST_NAME AS \"FULLNAME\"\r\n" + 
				"  FROM COMMENT_POST \r\n" + 
				"      LEFT JOIN PROFILE ON Comment_Post.memberid = PROFILE.memberid \r\n" + 
				"      JOIN MEMBER ON comment_post.memberid =  MEMBER.ID\r\n" + 
				"  WHERE COMMENT_POST.POSTID = ? ORDER BY COMMENT_POST.UPDATE_AT ASC";
		try {
			PreparedStatement stmt = ConnectionDAO.connection().prepareStatement(query);
			stmt.setInt(1, postId);
			rs = stmt.executeQuery();
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnectionDAO.connection().close();
		}
	}
	
	public static ResultSet getListPost(Integer memberId) throws SQLException{
		ResultSet rs;
		String query = "SELECT ID,TITLE, CONTENT, IMAGE,CREATE_AT, UPDATE_AT FROM POST WHERE POST.MEMBERID = ? ORDER BY CREATE_AT DESC";
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
	public static boolean updatePost(Post post)throws SQLException{
		String procedure = "{call proc_updatePost(?,?,?,?,?)}";
		try {
			CallableStatement callable = ConnectionDAO.connection().prepareCall(procedure);
			callable.setInt(1, post.getPostId());
			callable.setInt(2, post.getMemberId());
			callable.setString(3, post.getTitle());
			callable.setString(4, post.getContent());
			callable.registerOutParameter(5, java.sql.Types.INTEGER);
			callable.executeUpdate();
			Integer result = callable.getInt(5);
			if(result == 1)
				return true;
			return false;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionDAO.connection().close();
		}
	}
	
	public static ResultSet getPostWithPostId(Integer postID) throws SQLException{
		ResultSet rs;
		String query = "SELECT * FROM POST WHERE ID = ?";
		try {
			PreparedStatement stmt = ConnectionDAO.connection().prepareStatement(query);
			stmt.setInt(1, postID);
			rs = stmt.executeQuery();
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			ConnectionDAO.connection().close();
		}
	}
	
	public static String deletePostWithPostID(Integer postID,Integer memberID) throws SQLException{
		String query = "{? = call func_deletePostWithPostIDAndMemberId(?,?)}";
		try {
			CallableStatement callable = ConnectionDAO.connection().prepareCall(query);
			callable.registerOutParameter(1, java.sql.Types.VARCHAR);
			callable.setInt(2, postID);
			callable.setInt(3, memberID);
			callable.executeUpdate();
			return callable.getString(1);
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}finally {
			ConnectionDAO.connection().close();
		}
	}
}
