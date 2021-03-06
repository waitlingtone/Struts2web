package Model;

import java.sql.ResultSet;
public class Member {
	private Integer memberId;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String address;
	private String phone;
	private String passport;
	private Integer sex;
	private java.util.Date birthday;
	private String verifyCode;
	
	public Member() {}
	public Member(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		String name;
		name = firstname + " " + lastname;
		return name;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public Member getMemberById(Integer memberId) throws Exception{
		ResultSet rs = connection.oracle.MemberConnection.getInformationMember(memberId);
		if(rs != null) {
			while(rs.next()){
				this.setFirstname(rs.getString("first_name"));
				this.setLastname(rs.getString("last_name"));
				this.setAddress(rs.getString("Address"));
				this.setBirthday(rs.getDate("birthday"));
				this.setPhone(rs.getString("Phone"));
				this.setMemberId(memberId);
				this.setSex(rs.getInt("sex"));
				this.setEmail(rs.getString("email"));
				this.setPassport(rs.getString("passport"));
			}
		}
		return this;
	}
	

}
