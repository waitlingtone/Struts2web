package project.action;

import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.ActionMessage;
import org.apache.struts2.interceptor.ServletRequestAware;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Model.Member;
import Model.Profile;
import connection.oracle.ConnectionDAO;
import connection.oracle.ProfileConnection;

public class FileUploadAction extends ActionSupport implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File userImage;
	private String userImageContentType;
	private String userImageFileName;
	private Profile memProfile;
	private Member member;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query;
	Integer memberId = (Integer) ActionContext.getContext().getSession().get("memberId");
	public HttpServletRequest request;

	public String profileLoad() throws SQLException, ParseException
	{
		System.out.println(memberId);
		rs = (ResultSet) ProfileConnection.getProfileByID(memberId);
		memProfile = new Profile();
		member = new Member();
		String rString;
	
		while (rs.next()) {
			memProfile.setProfileId(rs.getInt("id"));
			memProfile.setUserId(memberId);
			memProfile.setAvatar("/Struts2web"+rs.getString("avatar"));
			memProfile.setCoverPhoto("/Struts2web"+rs.getString("coverphoto"));
			member.setUsername(rs.getString("username"));
			member.setFirstname(rs.getString("first_name"));
			member.setLastname(rs.getString("last_name"));
			member.setAddress(rs.getString("Address"));

			member.setBirthday(rs.getDate("birthday"));
			member.setPhone(rs.getString("Phone"));
			member.setMemberId(memberId);
			member.setSex(rs.getInt("sex"));
			member.setEmail(rs.getString("email"));
			member.setPassport(rs.getString("passport"));
//			session.put("userAva", memProfile.getAvatar());
		}
	
		System.out.println(member.getFirstname());
		System.out.println(member.getBirthday());
		rString = SUCCESS;
		System.out.println(rString);
		return SUCCESS;
	}
	@Override
	public String execute() throws Exception {
		try
		{	
			String concatStr = "/includes/pictures/avatar";
			
			String filePath = ServletActionContext.getServletContext().getRealPath("/").concat(concatStr);
			int findFirstDot = filePath.indexOf('.');
			String subString = filePath.substring(0, findFirstDot);
			String filePathProject = subString.concat("Struts2web/WebContent"+concatStr);
			System.out.println(subString);
			System.out.println("Image Loaction:" + filePath);			
			System.out.println("Project Inmage Location : "+ filePathProject);
			File filetoCreate = new File(filePath,userImageFileName);
			File filetoCreateProject = new File(filePathProject,userImageFileName);
			FileUtils.copyFile(userImage, filetoCreate);
			FileUtils.copyFile(userImage, filetoCreateProject);
	    
            
	        String local = "/includes/pictures/avatar/" + userImageFileName;
	        System.out.println(local);
	        query = "update PROFILE set avatar = ? where memberid= ?";
	        ps = ConnectionDAO.connection().prepareStatement(query);
	        ps.setString(1, local);
	        ps.setInt(2, memberId);
	        ps.executeUpdate();
	        return SUCCESS;
	        
		}
		catch(Exception e)
		{
			System.out.println("uploadPicAction" + e);
			return ERROR;
		}
		finally {
			ConnectionDAO.connection().close();
		}
	}
	public String saveDataChange() throws SQLException, ParseException
	{
		boolean isSuccess = ProfileConnection.updateProfilebyId(member);
		if(isSuccess == true)
		{	
			
			return SUCCESS;
		}
		return ERROR;
		
		
	}
	//Getter and Setter
	public File getUserImage() {
		return userImage;
	}
	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}
	public String getUserImageContentType() {
		return userImageContentType;
	}
	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}
	public String getUserImageFileName() {
		return userImageFileName;
	}
	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}
	 public Profile getMemProfile() {
			return memProfile;
		}
	public void setMemProfile(Profile memProfile) {
		this.memProfile = memProfile;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		 this.request = request;  
		
	}

}

	    
            
	        String local = "/includes/pictures/avatar/" + userImageFileName;
	        System.out.println(local);
	        query = "update PROFILE set avatar = ? where memberid= ?";
	        ps = ConnectionDAO.connection().prepareStatement(query);
	        ps.setString(1, local);
	        ps.setInt(2, memberId);
	        ps.executeUpdate();
	        return SUCCESS;
	        
		}
		catch(Exception e)
		{
			System.out.println("uploadPicAction" + e);
			return ERROR;
		}
		finally {
			ConnectionDAO.connection().close();
		}
	}
	public String saveDataChange() throws SQLException, ParseException
	{
		boolean isSuccess = ProfileConnection.updateProfilebyId(member);
		if(isSuccess == true)
		{	
			
			return SUCCESS;
		}
		return ERROR;
		
		
	}
	//Getter and Setter
	public File getUserImage() {
		return userImage;
	}
	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}
	public String getUserImageContentType() {
		return userImageContentType;
	}
	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}
	public String getUserImageFileName() {
		return userImageFileName;
	}
	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}
	 public Profile getMemProfile() {
			return memProfile;
		}
	public void setMemProfile(Profile memProfile) {
		this.memProfile = memProfile;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		 this.request = request;  
		
	}

}
