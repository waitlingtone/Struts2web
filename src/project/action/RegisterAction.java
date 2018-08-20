package project.action;
import com.opensymphony.xwork2.ActionSupport;

import Model.Member;

public class RegisterAction extends ActionSupport{
	
	Member member = null;
	
	public String execute() throws Exception{
		return SUCCESS;
	}
	
	public Member getMember() {
		return this.member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	

}
