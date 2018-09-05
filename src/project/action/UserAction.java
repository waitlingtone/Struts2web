package project.action;

import com.opensymphony.xwork2.ActionSupport;

import Model.Member;

public class UserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Member member = null;
	
	public String home() {
		return SUCCESS;
	}
	public String profile() {
		return SUCCESS;
	}
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
}
