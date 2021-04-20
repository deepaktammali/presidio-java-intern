package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public abstract class UserModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
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
