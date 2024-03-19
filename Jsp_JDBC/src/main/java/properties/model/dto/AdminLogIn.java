package properties.model.dto;

public class AdminLogIn {
	
	private String id;
	private String pw;
	private String adminName;

	public AdminLogIn() {}
	
	public AdminLogIn(String id, String pw, String adminName) {
		
		super();
		this.id = id;
		this.pw = pw;
		this.adminName = adminName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public String toString() {
		return "AdminLogIn [id=" + id + ", pw=" + pw + ", adminName=" + adminName + "]";
	}
	
	
	
	
}
