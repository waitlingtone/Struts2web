package project.action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Model.Member;

public class RegisterAction extends ActionSupport implements ModelDriven<Member>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Member member = null;
	
	public String execute() throws Exception{
		return SUCCESS;
	}
	public String registerMember() throws Exception{
//		boolean insertRs = connection.oracle.AuthenticateMemberConnection.registerMember(member);
//		if(insertRs)
//			return SUCCESS;
//		return ERROR;
		int rs = connection.oracle.AuthenticateMemberConnection.registerMember(member);
		if(rs == 1)
			return SUCCESS;
		return INPUT;
	}
	
	public Member getMember() {
		return this.member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public Member getModel() {
		return this.member;
	}
	

}
