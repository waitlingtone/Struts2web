package project.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Model.Member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	Member member = null;
	List<Member> list = null;
	java.util.Date date=new java.util.Date();  
	private Map<String, Object> session = ActionContext.getContext().getSession();
	
//	@VisitorFieldValidator
	public Member getMember() {
		return this.member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	
	public String login() throws Exception{
		Integer idOfMember = connection.oracle.AuthenticateMemberConnection.Authenticate(member);
		String rString = ERROR;
		if(idOfMember != 0) {
			session.put("memberId", idOfMember);
			member.setMemberId(idOfMember);
			if(idOfMember == -1)
			{
				
				rString= "needverify";
			}
			else {
			rString =  SUCCESS;
			}
		}
		
		System.out.println(rString);
		return rString;
	}
	
	@SkipValidation
	public String logout() throws Exception{
		session.remove("memberId");
		return SUCCESS;
	}
	
	public List<Member> getList(){
		return this.list;
	}
	
	public void setList(List<Member> list) {
		this.list = list;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession(){
		return this.session;
	}

}
