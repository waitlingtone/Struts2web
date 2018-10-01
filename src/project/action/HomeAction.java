package project.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.jndi.ldap.Connection;

import Model.*;
import connection.oracle.PostConnection;
import oracle.sql.DATE;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
public class HomeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Post post;
	private List<Post> list;
	private List<Comment> list_comment;
	private Profile profile;
	private Comment comment;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	private TriviaPost triviaPost;
	private TriviaComment triviaComment;
	
	public String getCommentWithPostId()throws Exception{
		profile = new Profile();
		triviaComment = new TriviaComment();
		list_comment = new ArrayList<>();
		
		profile.getProfileByMemberId((Integer) session.get("memberId"));

		list_comment = triviaComment.getCommentsByPostId(post.getPostId());
		if(list_comment != null)
			return SUCCESS;
		return ERROR;
		
//		ResultSet rs = connection.oracle.PostConnection.getListCommentWithPostId(post.getPostId());

//		if(rs != null) {
//			while(rs.next()) {
//				comment = new Comment();
//				comment.setId(rs.getInt("Id"));
//				comment.setMemberId(rs.getInt("MEMBERID"));
//				comment.setPostId(rs.getInt("POSTID"));
//				comment.setAvatar("/Struts2web" + rs.getString("avatar"));
//				comment.setContent(rs.getString("content"));
//				comment.setCmt_person(rs.getString("FULLNAME"));
//				comment.setCreate_at(rs.getDate("create_at"));
//				comment.setUpdate_at(rs.getDate("update_at"));
//				list_comment.add(comment);
//			}
//			
//			return SUCCESS;
//		}
//		return ERROR;
	}
	
	public String home() throws Exception {
		profile = new Profile();
		list = new ArrayList<>();
		triviaPost = new TriviaPost();
		profile.getProfileByMemberId((Integer) session.get("memberId"));
		
//		list = getListPostByMemberId((Integer) session.get("memberId"));
		
		list = triviaPost.getPostsByMemberId((Integer) session.get("memberId"));
		
		if(list != null) {
			return SUCCESS;
		}
		return ERROR;
	}
//	public List<Post> getListPostByMemberId(Integer memberid) throws SQLException{
//		ResultSet rs = connection.oracle.PostConnection.getListPost(memberid);
//		list = new ArrayList<>();
//		if(rs != null) {
//			while(rs.next()) {
//				Post post = new Post();
//				post.setPostId(rs.getInt("id"));
//				post.setTitle(rs.getString("title"));
//				post.setContent(rs.getString("content"));
//				post.setImage(rs.getString("Image"));
//				post.setPostDate(rs.getDate("UPDATE_AT"));
//				list.add(post);
//			}
//			return list;
//		}
//		return null;
//	}
	
//	protected void commentInfomation(Integer id) throws Exception{
//		ResultSet rs_profile = connection.oracle.ProfileConnection.getProfileByID(id);
//		if(rs_profile != null) {
//			while(rs_profile.next()) {
//				comment.setCmt_person(rs_profile.getString("first_name") + " " + rs_profile.getString("last_name"));
//				comment.setAvatar("/Struts2web"+rs_profile.getString("avatar"));
//				System.out.println(comment.getCmt_person()+" person");
//				System.out.println(comment.getAvatar());
//			}
//		}
//	}
	
	public String insertCommentPost()throws Exception {
		boolean isSuccess = comment.addCommentWithPostId(comment, (Integer) session.get("memberId"), post.getPostId());
		if(isSuccess) {
//			commentInfomation((Integer) session.get("memberId"));
			return SUCCESS;
		}
		return ERROR;
	}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	public String createPost() throws Exception{
		try {
			Date date = new Date();
			profile = new Profile();
			profile.getProfileByMemberId((Integer) session.get("memberId"));
			
			post.setMemberId((Integer) session.get("memberId"));
			post.setPostDate(date);
//			Integer isSuccess = connection.oracle.PostConnection.createPost(post);
			boolean rs = post.insertPost();
			if(rs) {
				return SUCCESS;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return ERROR;
	}

	public List<Post> getList() {
		return list;
	}

	public void setList(List<Post> list) {
		this.list = list;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public List<Comment> getList_comment() {
		return list_comment;
	}
	public void setList_comment(List<Comment> list_comment) {
		this.list_comment = list_comment;
	}
	public TriviaPost getTriviaPost() {
		return triviaPost;
	}
	public void setTriviaPost(TriviaPost triviaPost) {
		this.triviaPost = triviaPost;
	}

	public TriviaComment getTriviaComment() {
		return triviaComment;
	}

	public void setTriviaComment(TriviaComment triviaComment) {
		this.triviaComment = triviaComment;
	}

}
