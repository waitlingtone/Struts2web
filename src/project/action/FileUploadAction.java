package project.action;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.ActionMessage;
import org.apache.struts2.interceptor.ServletRequestAware;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Model.Member;
import Model.Profile;
import connection.oracle.ConnectionDAO;
import connection.oracle.ProfileConnection;

public class FileUploadAction extends ActionSupport{
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
	
	public String profileLoad() throws SQLException
	{
		
		rs = (ResultSet) ProfileConnection.getProfileByID(memberId);
		memProfile = new Profile();
		member = new Member();
	
		while (rs.next()) {
			memProfile.setProfileId(rs.getInt("id"));
			memProfile.setUserId(memberId);
			memProfile.setAvatar("/Struts2web"+rs.getString("avatar"));
			memProfile.setCoverPhoto("/Struts2web"+rs.getString("coverphoto"));
			member.setUsername(rs.getString("username"));
			member.setFirstname(rs.getString("first_name"));
			member.setLastname(rs.getString("last_name"));
			member.setAddress(rs.getString("Address"));
			member.setBirthday(rs.getDate("Birthday"));
			member.setPhone(rs.getString("Phone"));
			member.setMemberId(memberId);
			
//			session.put("userAva", memProfile.getAvatar());
		}
		
		return SUCCESS;
	}
	@Override
	public String execute() throws Exception {
		try
		{	
			String concatStr = "includes/pictures/avatar";
			String filePath = ServletActionContext.getServletContext().getRealPath("/").concat(concatStr);
			System.out.println("Image Loaction:" + filePath);
			File fileToCreate = new File(filePath,userImageFileName);
			FileUtils.copyFile(userImage, fileToCreate);
	    
            
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

}
