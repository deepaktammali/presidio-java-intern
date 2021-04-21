package model;

import javax.persistence.*;

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	@Column
	String name;
	@Column
	String mobileNumber;
	@Column
	String address;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, String mobileNumber, String address) {
		this.id = null;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}
	
	public Customer(Integer id, String name, String mobileNumber, String address) {
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
