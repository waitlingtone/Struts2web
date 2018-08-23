package connection.oracle;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Member;


public class LoginConnection {
	
	public static boolean Authenticate(Member member) throws Exception{
		ResultSet rs = null;
		String hashPass = connection.oracle.LoginConnection.getHashedPassword(member);
		String sql = "SELECT * FROM member WHERE username = ? and password = ?";
		try {
				PreparedStatement stmt = ConnectionDAO.connection().prepareStatement(sql);
				stmt.setString(1,member.getUsername());
				stmt.setString(2,hashPass);
				rs = stmt.executeQuery();
			return rs.next();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
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
	

	public static boolean registerMember(Member member) throws Exception{
		ResultSet rs = null;
		String sql = "Insert into MEMBER(username, password, email, first_name, last_name, address, phone, passport, sex, birthday) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		java.sql.Date bornin = new java.sql.Date(member.getBirthday().getTime());
		String encryptPass = connection.oracle.LoginConnection.getHashedPassword(member);
		try {
				PreparedStatement stmt = ConnectionDAO.connection().prepareStatement(sql);
				stmt.setString(1,member.getUsername());
				stmt.setString(2,encryptPass);
				stmt.setString(3,member.getEmail());
				stmt.setString(4,member.getFirstname());
				stmt.setString(5,member.getLastname());
				stmt.setString(6,member.getAddress());
				stmt.setString(7,member.getPhone());
				stmt.setString(8,member.getPassport());
				stmt.setInt(9, member.getSex());
				stmt.setDate(10, bornin);
				rs = stmt.executeQuery();
			return rs.next();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
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
