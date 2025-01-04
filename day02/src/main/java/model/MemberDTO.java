package model;

public class MemberDTO {
	private String userName;
	private String id;
	private String pw;
	private String addr;
	private String age;
	
	public MemberDTO(String userName, String id, String pw, String addr, String age) {
		this.userName = userName;
		this.id = id;
		this.pw = pw;
		this.addr = addr;
		this.age = age;
	}
	public String getUserName() { return userName;	}
	public String getId() {	return id;	}
	public String getPw() {	return pw;	}
	public String getAddr() { return addr;	}
	public String getAge() { return age;	}
}
