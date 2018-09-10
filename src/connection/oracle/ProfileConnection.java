package connection.oracle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import Model.Member;
import Model.Profile;
import javassist.bytecode.stackmap.BasicBlock.Catch;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class ProfileConnection {
	static ResultSet rs = null; 
	static Profile memProfile = null;

	
	public static ResultSet getProfileByID(Integer memberid) throws SQLException 
	{
		try {
			
			String psQuery = "SELECT * FROM PROFILE WHERE MEMBERID = ?";
			PreparedStatement ps = ConnectionDAO.connection().prepareStatement(psQuery);
			ps.setInt(1, memberid);
			rs = ps.executeQuery();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
}
