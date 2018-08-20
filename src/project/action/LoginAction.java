package project.action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;
import Model.Member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	Member member = null;
	List<Member> list = null;

	public Member getMember() {
		return this.member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public String checkOracleConnection() {
		Connection conn = connection.oracle.ConnectionDAO.connection();
		if(conn == null)
			return ERROR;
		return SUCCESS;
	}
	public String checkLogin() throws Exception{
		boolean authenticate = connection.oracle.LoginConnection.Authenticate(member.getUsername(),member.getPassword());
		if(authenticate) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String report() throws Exception{
		ResultSet rs = connection.oracle.LoginConnection.exeQ("SELECT USERNAME, PASSWORD, FIRST_NAME, LAST_NAME FROM MEMBER");
		list = new ArrayList<>();
		if(rs != null) {
			while(rs.next()) {
				member = new Member();
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("Password"));
				member.setFirst_name(rs.getString("first_name"));
				member.setLast_name(rs.getString("last_name"));
				list.add(member);
			}
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
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

}
