package project.action;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Model.Profile;
import connection.oracle.ConnectionDAO;
import connection.oracle.ProfileConnection;
import oracle.ucp.jdbc.oracle.rlb.ONSRuntimeLoadBalancingEvent;

public class FileUploadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File userImage;
	private String userImageContentType;
	private String userImageFileName;
	Profile memProfile = null;
    PreparedStatement ps = null;
	ResultSet rs = null;
	String query;
	private Map<String, Object> session;
	Integer memberId = (Integer) ActionContext.getContext().getSession().get("memberId");
	
	public String profileLoad() throws SQLException
	{
		
		rs = (ResultSet) ProfileConnection.getProfileByID(memberId);
		memProfile = new Profile();

	
		while (rs.next()) {
			memProfile.setProfileId(rs.getInt("id"));
			memProfile.setUserId(memberId);
			memProfile.setAvatar(rs.getString("avatar"));
			memProfile.setCoverphoto(rs.getString("coverphoto"));
//			session.put("userAva", memProfile.getAvatar());
		}
		
		
		return SUCCESS;
	}
	@Override
	public String execute() throws Exception {
		try
		{
			String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("includes/pictures/avatar");
	        System.out.println("Image Location:" + filePath);//see the server console for actual location  
	        File fileToCreate = new File(filePath,userImageFileName);
	        FileUtils.copyFile(userImage, fileToCreate);//copying source file to new file
	        
	        
	        String loc = "includes/pictures/avatar/"+userImageFileName;
	        query = "update PROFILE set avatar = ? where memberid= ?";
	        
	        ps = ConnectionDAO.connection().prepareStatement(query);
	        ps.setString(1, loc);
	        ps.setInt(2, memberId);
	        System.out.println(query);
	        ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("uploadPicAction" + e);
		}
		return SUCCESS;
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
	

}
