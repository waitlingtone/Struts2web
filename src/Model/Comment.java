package Model;

public class Comment {
	private int id;
	private int postId;
	private Integer memberId;
	private String content;
	private java.util.Date create_at;
	private java.util.Date update_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
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

}
