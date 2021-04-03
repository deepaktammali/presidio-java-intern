package datamodel.baseclass;

public abstract class CustomerDataModel {
	protected Integer id;
	protected String name;
	protected String mobileNumber;
	protected String address;
	
	public CustomerDataModel(String name, String mobileNumber, String address) {
		this.id = null;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}
	
	public CustomerDataModel(Integer id, String name, String mobileNumber, String address) {
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
