package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TriviaMember {
	private List<Member> mMembers;
	
	public List<Member> getmMembers() {
		return mMembers;
	}

	public void setmMembers(List<Member> mMembers) {
		this.mMembers = mMembers;
	}
	public List<Member> searchMemberByName(String name) throws Exception{
		ResultSet rs = connection.oracle.MemberConnection.searchMemberByName(name);
		List<Member> arrMember = new ArrayList<>();
		if(rs != null) {
			Member member;
			while(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getInt("ID"));
				member.setFirstname(rs.getString("first_name"));
				member.setLastname(rs.getString("last_name"));
				arrMember.add(member);
			}
			return arrMember;
		}
		return null;
	}
}
