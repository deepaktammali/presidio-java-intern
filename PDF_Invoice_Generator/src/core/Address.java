package core;

import java.util.*;

public class Address {
	private String companyName;
	private String contactName;
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private int zipCode;
	private String phoneNumber;
	private String emailAddress;

	public Address(String companyName, String contactName, String streetAddress, String city, String state,
			String country, int zipCode, String phoneNumber, String emailAddress) {
		super();
		this.companyName = companyName;
		this.contactName = contactName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	public Map<String,Object> toMap(){
		Map<String,Object> addressMap = new LinkedHashMap<>();
		
		addressMap.put("companyName",companyName);
		addressMap.put("contactName",contactName );
		addressMap.put("streetAddress",streetAddress );
		addressMap.put("city",city);
		addressMap.put("state",state );
		addressMap.put("country", country);
		addressMap.put("zipCode", zipCode);
		addressMap.put("phoneNumber", phoneNumber);
		addressMap.put("emailAddress",emailAddress );
		
		return addressMap;
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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
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
