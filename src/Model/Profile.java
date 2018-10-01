package Model;

import java.sql.ResultSet;

import connection.oracle.ProfileConnection;

public class Profile {
	private Integer profileId;
	private Integer userId;
	private String avatar;
	private String coverPhoto;
	
	public Profile() {};
	public Profile(Integer profileId, Integer userId, String avatar, String coverPhoto) {
		this.profileId = profileId;
		this.userId = userId;
		this.avatar = avatar;
		this.coverPhoto = coverPhoto;
	}
	// Getter and setter
	public Integer getProfileId() {
		return profileId;
	}
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
			this.avatar = avatar;
	}
	public String getCoverPhoto() {
		return coverPhoto;
	}
	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}
	public Profile getProfileByMemberId(Integer id)throws Exception {
		ResultSet rs = (ResultSet) ProfileConnection.getProfileByID(id);
		while (rs.next()) {
			this.setProfileId(rs.getInt("id"));
			this.setUserId(id);
			this.setAvatar("/Struts2web"+rs.getString("avatar"));
			this.setCoverPhoto("/Struts2web"+rs.getString("coverphoto"));
		}
		return this;
	}
	
}
