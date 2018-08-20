package Model;
public class Member {
	private String username;
	private String password;
	private String f_name;
	private String l_name;
	
	public Member() {}
	public Member(String username, String password) {
		this.username = username;
		this.password = password;
	}
//	@RequiredStringValidator(key = "Username is required", trim = true)
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
//	@RequiredStringValidator(key = "Password is required", trim = true)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return f_name;
	}

	public void setFirst_name(String first_name) {
		this.f_name = first_name;
	}

	public String getLast_name() {
		return l_name;
	}

	public void setLast_name(String last_name) {
		this.l_name = last_name;
	}
}
