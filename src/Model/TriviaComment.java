package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TriviaComment {
	private List<Comment> mComments;

	public List<Comment> getmComments() {
		return mComments;
	}

	public void setmComments(List<Comment> mComments) {
		this.mComments = mComments;
	}
	
	public List<Comment> getCommentsByPostId(Integer postId)throws Exception {
		ResultSet rs = connection.oracle.PostConnection.getListCommentWithPostId(postId);
		List<Comment> listCmt = new ArrayList<>();
		if(rs != null) {
			Comment comment;
			while(rs.next()) {
				comment = new Comment();
				comment.setId(rs.getInt("Id"));
				comment.setMemberId(rs.getInt("MEMBERID"));
				comment.setPostId(rs.getInt("POSTID"));
				comment.setAvatar("/Struts2web" + rs.getString("avatar"));
				comment.setContent(rs.getString("content"));
				comment.setCmt_person(rs.getString("FULLNAME"));
				comment.setCreate_at(rs.getDate("create_at"));
				comment.setUpdate_at(rs.getDate("update_at"));
				listCmt.add(comment);
			}
			setmComments(listCmt);
			return mComments;
		}
		return null;
	}
}
