package connection.oracle;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.Member;

public class AuthenticateMemberConnection {
	
	
	public static Integer Authenticate(Member member) throws Exception{
		Integer authenticate = 2;
		String hashPass = getHashedPassword(member);
		String func_authenticate = "{? = call authenticate_member(?,?)}";
		try {
			CallableStatement func = ConnectionDAO.connection().prepareCall(func_authenticate);
			func.registerOutParameter(1, java.sql.Types.INTEGER);
			func.setString(2, member.getUsername());
			func.setString(3, hashPass);
			func.executeUpdate();
			authenticate = func.getInt(1);
			return authenticate;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			ConnectionDAO.connection().close();
		}
	}

	
	public static ResultSet exeQ(String query) throws Exception{
		ResultSet rs = null;
		try {
			Statement statement = ConnectionDAO.connection().createStatement();
			rs = statement.executeQuery(query);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionDAO.connection().close();
		}
	}
	public static Integer registerMember(Member member) throws Exception{
		String proc_insertMember = "call insert_member(?,?,?,?,?,?,?,?,?,?,?)";
		String encryptPassword = getHashedPassword(member);
		java.sql.Date birthday = new java.sql.Date(member.getBirthday().getTime());
		int rs = 0;
		try {
			CallableStatement call_proc = ConnectionDAO.connection().prepareCall(proc_insertMember);
			call_proc.setString(1, member.getUsername());
			call_proc.setString(2, encryptPassword);
			call_proc.setString(3, member.getEmail());
			call_proc.setString(4, member.getFirstname());
			call_proc.setString(5, member.getLastname());
			call_proc.setInt(6, member.getSex());
			call_proc.setDate(7, birthday);
			call_proc.setString(8, member.getAddress());
			call_proc.setString(9, member.getPhone());
			call_proc.setString(10, member.getPassport());
			call_proc.registerOutParameter(11, java.sql.Types.INTEGER);
			call_proc.executeUpdate();
			rs = call_proc.getInt(11);
			return rs;
		} catch(Exception e) {
			e.printStackTrace();
			return rs;
		}finally {
			ConnectionDAO.connection().close();
		}
	}
	
	 public static String getHashedPassword(Member member) throws Exception {
		    MessageDigest objMsgDigest;
		    try {
		        objMsgDigest = MessageDigest.getInstance("SHA-1");
		        objMsgDigest.update(member.getPassword().getBytes("UTF-8"));
		    } catch (NoSuchAlgorithmException e) {
		        throw e;
		    } catch (UnsupportedEncodingException e) {
		        throw e;
		    }
		    byte byteHash[] = objMsgDigest.digest();
		    String strHashPwd = "";
		    int lenght = byteHash.length;
		    for (int i = 0; i <  lenght ; i++) {

		        // for (byte aByteHash : byteHash) {
		        strHashPwd += Integer.toHexString(byteHash[i] & 0xff);
		    }
		    return strHashPwd;
		}
}
