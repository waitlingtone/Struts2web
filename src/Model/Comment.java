package Model;

import java.sql.ResultSet;

public class Comment {
	private Integer id;
	private Integer postId;
	private Integer memberId;
	private String cmt_person;
	private String avatar;
	private String content;
	private java.util.Date create_at;
	private java.util.Date update_at;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.util.Date getCreate_at() {
		return create_at;
	}
	public void setCreate_at(java.util.Date create_at) {
		this.create_at = create_at;
	}
	public java.util.Date getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(java.util.Date update_at) {
		this.update_at = update_at;
	}
	public String getCmt_person() {
		return cmt_person;
	}
	public void setCmt_person(String cmt_person) {
		this.cmt_person = cmt_person;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public boolean addCommentWithPostId(Comment comment, Integer memberID, Integer postID) throws Exception{
		boolean result = connection.oracle.PostConnection.addCommentWithPostId(comment, memberID, postID);
		if(result) {
			getInformationPersonComment(memberID);
			return true;
		}
		return false;
	}
	protected void getInformationPersonComment(Integer memberID) throws Exception{
		ResultSet rs_profile = connection.oracle.ProfileConnection.getProfileByID(memberID);
		if(rs_profile != null) {
			while(rs_profile.next()) {
				this.setMemberId(memberID);
				this.setCmt_person(rs_profile.getString("first_name") + " " + rs_profile.getString("last_name"));
				this.setAvatar("/Struts2web"+rs_profile.getString("avatar"));
			}
		}
	}
}
