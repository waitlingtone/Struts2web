package project.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionWsaClientTube;

import java.sql.ResultSet;
import java.util.*;

import Model.*;


public class UserAction extends ActionSupport{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Member member;
	private List<Member> list_member;
	private Profile profile;
	private Post post;
	private TriviaPost trivia_post;
	public TriviaMember triviaMember;
	
	public TriviaMember getTriviaMember() {
		return triviaMember;
	}

	public void setTriviaMember(TriviaMember triviaMember) {
		this.triviaMember = triviaMember;
	}
	private List<Post> list_post;
	private Integer id;

	private String name;
	public String searchMemberByName() throws Exception{
//		ResultSet rs = connection.oracle.MemberConnection.searchMemberByName(name);
		list_member = new ArrayList<>();
//		if(rs != null) {
//			while(rs.next()) {
//				member = new Member();
//				member.setMemberId(rs.getInt("ID"));
//				member.setFirstname(rs.getString("first_name"));
//				member.setLastname(rs.getString("last_name"));
//				list_member.add(member);
//				System.out.println(rs.getString("first_name"));
//			}
//			return SUCCESS;
//		}
//		return ERROR;
		triviaMember = new TriviaMember();
		list_member = triviaMember.searchMemberByName(name);
		if(list_member !=null)
			return SUCCESS;
		return ERROR;
		
	}
	public String getUserSearchById(){		
		trivia_post = new TriviaPost();
		list_post = new ArrayList<>();
		member = new Member();
		profile = new Profile();
		try {
			member.getMemberById(id);
			profile.getProfileByMemberId(id);
			System.out.println(profile.getCoverPhoto() + " " + profile.getAvatar());
			list_post = trivia_post.getPostsByMemberId(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/*************************************** GETTER SETTER *************************************************/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Profile getProfile() {
		return profile;
	}
	
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public TriviaPost getTrivia_post() {
		return trivia_post;
	}

	public void setTrivia_post(TriviaPost trivia_post) {
		this.trivia_post = trivia_post;
	}

	public List<Post> getList_post() {
		return list_post;
	}

	public void setList_post(List<Post> list_post) {
		this.list_post = list_post;
	}
	public List<Member> getList_member() {
		return list_member;
	}

	public void setList_member(List<Member> list_member) {
		this.list_member = list_member;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/*************************************** END GETTER SETTER *************************************************/
}
