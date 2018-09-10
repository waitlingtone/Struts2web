package project.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.jndi.ldap.Connection;

import Model.Post;
import connection.oracle.PostConnection;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
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
	private Map<String, Object> session = ActionContext.getContext().getSession();
	public String home() throws SQLException {
		ResultSet rs = connection.oracle.PostConnection.getListPost((Integer) session.get("memberId"));
		list = new ArrayList<>();
		if(rs != null) {
			while(rs.next()) {
				Post post = new Post();
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
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
			post.setMemberId((int) session.get("memberId"));
			Integer isSuccess = connection.oracle.PostConnection.createPost(post);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
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
}
