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
	
	protected void getProfileImage(Integer id)throws SQLException {
	profile = new Profile();
	ResultSet rs = connection.oracle.ProfileConnection.getProfileByID(id);
		while(rs.next()) {
			profile.setAvatar("/Struts2web"+rs.getString("Avatar"));
			profile.setCoverPhoto(rs.getString("CoverPhoto"));
		}
	}
	public String getCommentWithPostId()throws Exception{
		ResultSet rs_comment_list = connection.oracle.PostConnection.getListCommentWithPostId(post.getPostId());
		list_comment = new ArrayList<>();
		if(rs_comment_list != null) {
			while(rs_comment_list.next()) {
				comment = new Comment();
				comment.setId(rs_comment_list.getInt("Id"));
				comment.setContent(rs_comment_list.getString("content"));
				list_comment.add(comment);
			}
			return SUCCESS;
		}
		return ERROR;
	}
	public String home() throws SQLException {
		getProfileImage((Integer) session.get("memberId"));
		ResultSet rs = connection.oracle.PostConnection.getListPost((Integer) session.get("memberId"));
		list = new ArrayList<>();
		if(rs != null) {
			while(rs.next()) {
				Post post = new Post();
				post.setPostId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setImage(rs.getString("Image"));
				post.setPostDate(rs.getDate("UPDATE_AT"));
				list.add(post);
			}
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String insertCommentPost()throws Exception {
		boolean isSuccess = connection.oracle.PostConnection.addCommentWithPostId(comment, (Integer) session.get("memberId"), post.getPostId());
		if(isSuccess) {
			System.out.println(post.getContent());
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
			getProfileImage((Integer) session.get("memberId"));
			post.setMemberId((int) session.get("memberId"));
			post.setPostDate(date);
			Integer isSuccess = connection.oracle.PostConnection.createPost(post);
			System.out.println(post);
			if(isSuccess == 1) {
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
}
