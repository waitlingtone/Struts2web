package Model;

public class Profile {
	private int profileId;
	private int userId;
	private String avatar;
	private String coverPhoto;
	
	public Profile() {};
	public Profile(int profileId, int userId, String avatar, String coverPhoto) {
		this.profileId = profileId;
		this.userId = userId;
		this.avatar = avatar;
		this.coverPhoto = coverPhoto;
	}
	// Getter and setter
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
	public void setCoverphoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}
	
}
