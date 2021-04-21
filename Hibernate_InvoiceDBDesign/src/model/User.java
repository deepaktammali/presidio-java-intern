package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	@Column(nullable=false)
	String username;
	@Column(nullable=false)
	String password;
	@Column(nullable=false)
	String flag;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password, String flag) {
		super();
		this.id=null;
		this.username = username;
		this.password = password;
		this.flag = flag;
	}
	public User(Integer id, String username, String password, String flag) {
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Username:%s Password:%s \n ", username,password);
	}
	
}
