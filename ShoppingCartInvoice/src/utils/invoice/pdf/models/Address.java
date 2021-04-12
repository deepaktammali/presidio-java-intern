package utils.invoice.pdf.models;

import java.util.*;

public class Address {
	private String companyName;
	private String contactName;
	private String companyAddress;
	private String phoneNumber;
	private String emailAddress;
	
	public Address(String companyName, String contactName, String companyAddress, String phoneNumber,
			String emailAddress) {
		super();
		this.companyName = companyName;
		this.contactName = contactName;
		this.companyAddress = companyAddress;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	

}
