package model;

public class UserDTO {
	private String uid;
	private String pw;
	
	public UserDTO() {}
	
	public UserDTO(String uid, String pw) {
		super();
		this.uid = uid;
		this.pw = pw;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}


