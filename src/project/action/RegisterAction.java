package project.action;
import com.opensymphony.xwork2.ActionSupport;

import Model.Member;

public class RegisterAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Member member = null;
	
	public String execute() throws Exception{
		return SUCCESS;
	}
	public String insertMember() throws Exception{
		boolean insertRs = connection.oracle.LoginConnection.registerMember(member);
		if(insertRs)
		{
			
			return SUCCESS;
		}
		return ERROR;
	}
	
	public Member getMember() {
		return this.member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	

}
