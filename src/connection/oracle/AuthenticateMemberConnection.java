package connection.oracle;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

import com.opensymphony.xwork2.ActionContext;

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
			System.out.println(authenticate);
			return authenticate;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			ConnectionDAO.connection().close();
		}
	}
	public static Integer isVerifyByCode(Integer id) throws SQLException {
		String proQuery = "{call check_verify_yet(?, ?)}";
		Integer rs = 0;
		try {
			CallableStatement proCall = ConnectionDAO.connection().prepareCall(proQuery);
			proCall.setInt(1,id);
			proCall.registerOutParameter(2, java.sql.Types.INTEGER);
			proCall.executeUpdate();
			System.out.println("id" + id + "ProID" +proCall.getInt(1));
			rs = proCall.getInt(2);
			System.out.println(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			ConnectionDAO.connection().close();
		}
		return  rs;
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
//	public static void saveHashVerifyCode(Integer id,String hashCode) throws SQLException {
//		ResultSet rSet = null;
//		String insertQuery = "
//			PreparedStatement preparedStatement = ConnectionDAO.connection().prepareStatement("insertQuery");
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
//		finally {
//			ConnectionDAO.connection().close();
//		}
//	}
	public static Integer isSuccessCheckCode(String code, String email) throws SQLException {
		String func_check = "{ ? = call check_verify_code(? , ?)}";
		Integer rs ;
		try {
			CallableStatement callableStatement= ConnectionDAO.connection().prepareCall(func_check);
			callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
			callableStatement.setString(2, code);
			callableStatement.setString(3, email );
			callableStatement.executeUpdate();
			rs = callableStatement.getInt(1);
			return rs;	
		}
		catch (Exception e) {
			e.printStackTrace();
			rs = 0;
			return rs;
		}
		finally {
			ConnectionDAO.connection().close();
		}
	}
	
	public static Integer registerMember(Member member) throws Exception{
		String proc_insertMember = "{call insert_member(?,?,?,?,?,?,?,?,?,?,?,?)}";
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
			call_proc.setString(11, member.getVerifyCode());
			call_proc.registerOutParameter(12, java.sql.Types.INTEGER);
			
			call_proc.executeUpdate();
			rs = call_proc.getInt(12);
			return rs;
		} catch(Exception e) {
			e.printStackTrace();
			return rs;
		}finally {
			ConnectionDAO.connection().close();
		}
	}
//All functions here
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
