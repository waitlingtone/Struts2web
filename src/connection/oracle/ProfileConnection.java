package connection.oracle;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionWsaClientTube;

import Model.Member;
import Model.Profile;
import javassist.bytecode.stackmap.BasicBlock.Catch;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class ProfileConnection {
	static ResultSet rs = null; 
	static Profile memProfile = null;
	static Member member = new Member();

	
	public static ResultSet getProfileByID(Integer memberid) throws SQLException 
	{
		try {
			
			String psQuery = "SELECT * FROM PROFILE p JOIN Member m ON p.MemberID = m.id  WHERE m.id = ?";
			PreparedStatement ps = ConnectionDAO.connection().prepareStatement(psQuery);
			ps.setInt(1, memberid);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			connection.oracle.ConnectionDAO.connection().close();
		}
		
	}
	public static boolean updateProfilebyId(Member member) throws SQLException
	{
		try {
			String call_updateMember = "call update_member(?,?,?,?,?)";
//			java.sql.Date newBirthday = new java.sql.Date( member.getBirthday().getTime());
			CallableStatement cStatement = ConnectionDAO.connection().prepareCall(call_updateMember);
			cStatement.setInt(1, member.getMemberId());
			cStatement.setString(2, member.getFirstname());
			cStatement.setString(3, member.getLastname());
			cStatement.setString(4, member.getAddress());
			cStatement.setString(5, member.getPhone());
			cStatement.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			ConnectionDAO.connection().close();
		}
	}
	
}
