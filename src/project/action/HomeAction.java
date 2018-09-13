package project.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.jndi.ldap.Connection;

import Model.*;
import connection.oracle.PostConnection;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class HomeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Post post;
	private List<Post> list;
	private Profile profile;
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
	protected void getProfileImage(Integer id)throws SQLException {
	profile = new Profile();
	ResultSet rs = connection.oracle.ProfileConnection.getProfileByID(id);
		while(rs.next()) {
			profile.setAvatar("/Struts2web"+rs.getString("Avatar"));
			profile.setCoverphoto(rs.getString("CoverPhoto"));
		}
	}
	public String home() throws SQLException {
		getProfileImage((Integer) session.get("memberId"));
		ResultSet rs = connection.oracle.PostConnection.getListPost((Integer) session.get("memberId"));
		list = new ArrayList<>();
		if(rs != null) {
			while(rs.next()) {
				Post post = new Post();
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setImage(rs.getString("Image"));
				post.setPostDate((java.util.Date) rs.getDate("update_at"));
				list.add(post);
			}
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
			getProfileImage((Integer) session.get("memberId"));
			post.setMemberId((int) session.get("memberId"));
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
}
