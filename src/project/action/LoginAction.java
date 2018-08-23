package project.action;
import com.opensymphony.xwork2.ActionSupport;
import Model.Member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	Member member = null;
	List<Member> list = null;
	java.util.Date date=new java.util.Date();  
	
	
	
//	@VisitorFieldValidator
	public Member getMember() {
		return this.member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	
	public String checkLogin() throws Exception{
		boolean authenticate = connection.oracle.LoginConnection.Authenticate(member);
		if(authenticate) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public List<Member> getList(){
		return this.list;
	}
	
	public void setList(List<Member> list) {
		this.list = list;
	}

}
