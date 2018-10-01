package Model;

import java.util.Date;

public class Post {
	private Integer postId;
	
	private String title;
	private String content;
	
	private Integer memberId;
	private String image;
	private Date updateAt;
	private Date postDate;
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberid) {
		this.memberId = memberid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	/********************************************************************************/
	/********************************** Method ************************************/
	/********************************************************************************/
	public boolean insertPost() throws Exception{
		Integer result = connection.oracle.PostConnection.createPost(this);
		if(result == 1)
			return true;
		return false;
	}
	
	public boolean editPost()throws Exception{
		return connection.oracle.PostConnection.updatePost(this);
	}
	public boolean removePost()throws Exception{
		return true;
	}
	/********************************************************************************/
		/****************************** End *************************************/
	/********************************************************************************/

}
