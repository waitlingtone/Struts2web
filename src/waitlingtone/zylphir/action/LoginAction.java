package waitlingtone.zylphir.action;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	Member member = null;
	List<Member> list = null;
	
	public String checkOracleConnection() {
		Connection conn = waitlingtone.zylphir.action.ConnectionDAO.connection();
		if(conn == null)
			return ERROR;
		return SUCCESS;
	}
	
	public String report() throws Exception{
		ResultSet rs = waitlingtone.zylphir.action.ConnectionDAO.report();
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

}
