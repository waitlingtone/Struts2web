package project.action;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import Model.*;
public class PostAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Profile profile;
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Post post;
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public String editPost()throws Exception {
		if(post.editPost()) {
			profile = new Profile();
			profile.getProfileByMemberId(post.getMemberId());
			return SUCCESS;	
		}
		return ERROR;
	}
	public String showEditPost(){
		try {
			ResultSet rs = connection.oracle.PostConnection.getPostWithPostId(post.getPostId());
			post = new Post();
			if(rs != null) {
				while(rs.next()) {
					post.setPostId(rs.getInt("ID"));
					post.setMemberId(rs.getInt("memberId"));
					post.setTitle(rs.getString("title"));
					post.setContent(rs.getString("content"));
				}
			}
			return SUCCESS;
		}catch(SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String deletePost() {
		
		return SUCCESS;
	}
	
	
}
