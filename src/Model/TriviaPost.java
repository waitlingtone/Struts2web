package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TriviaPost {
	private List<Post> mPosts;

	public List<Post> getmPosts() {
		return mPosts;
	}

	public void setmPosts(List<Post> mPosts) {
		this.mPosts = mPosts;
	}
	public List<Post> getPostsByMemberId(Integer memberid) throws Exception{
		ResultSet rs = connection.oracle.PostConnection.getListPost(memberid);
		List<Post> arrPost = new ArrayList<>();
		if(rs != null) {
			while(rs.next()) {
				Post post = new Post();
				post.setPostId((Integer)rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setImage(rs.getString("Image"));
				post.setUpdateAt(rs.getDate("UPDATE_AT"));
				post.setPostDate(rs.getDate("CREATE_AT"));
				arrPost.add(post);
			}
			return arrPost;
		}
		return null;
	}
}
