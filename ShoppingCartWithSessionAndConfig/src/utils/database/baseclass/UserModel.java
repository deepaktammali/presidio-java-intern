package utils.database.baseclass;

public abstract class UserModel {
	private Integer id;
	private String username;
	private String password;
	private String flag;
	
	public UserModel(String username, String password, String flag) {
		super();
		this.id=null;
		this.username = username;
		this.password = password;
		this.flag = flag;
	}
	public UserModel(Integer id, String username, String password, String flag) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.flag = flag;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
