package project.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Model.Member;

public class TestConnectionAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Member member = null;
	List<Member> list = null;
	public String checkOracleConnection() {
		Connection conn = connection.oracle.ConnectionDAO.connection();
		if(conn == null)
			return ERROR;
		return SUCCESS;
	}

	public String report() throws Exception{
		ResultSet rs = connection.oracle.AuthenticateMemberConnection.exeQ("SELECT Id, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME FROM MEMBER");
		list = new ArrayList<>();
		if(rs != null) {
			while(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getInt("Id"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("Password"));
				member.setFirstname(rs.getString("first_name"));
				member.setLastname(rs.getString("last_name"));
				list.add(member);
			}
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
	public List<Member> getList(){
		return this.list;
	}
	
	public void setList(List<Member> list) {
		this.list = list;
	}

}
