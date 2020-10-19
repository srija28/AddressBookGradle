package com.capgemini;

public class Contacts {
	private String firstName, lastName, name, address, city, state, zip, phoneNo, email;

	ValidateContact validateContact = new ValidateContact();
	
	public Contacts() {

	}
	
	public Contacts(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNo, String email) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddress(address);
		this.setCity(city);
		this.setState(state);
		this.setZip(zip);
		this.setPhoneNo(phoneNo);
		this.setEmail(email);
	}

	public String getFirstName() {
		return firstName;
	}

	public boolean setFirstName(String firstName) {
		boolean matchFound = validateContact.validateFirstName(firstName);
		if (matchFound)
			this.firstName = firstName;
		return matchFound;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean setLastName(String lastName) {
		boolean matchFound = validateContact.validateLastName(lastName);
		if (matchFound)
			this.lastName = lastName;
		return matchFound;
	}

	public String getAddress() {
		return address;
	}

	public boolean setAddress(String address) {
		boolean matchFound = validateContact.validateAddress(address);
		if (matchFound)
			this.address = address;
		return matchFound;
	}

	public String getCity() {
		return city;
	}

	public boolean setCity(String city) {
		boolean matchFound = validateContact.validateCity(city);
		if (matchFound)
			this.city = city;
		return matchFound;
	}

	public String getState() {
		return state;
	}

	public boolean setState(String state) {
		boolean matchFound = validateContact.validateState(state);
		if (matchFound)
			this.state = state;
		return matchFound;
	}

	public String getZip() {
		return zip;
	}

	public boolean setZip(String zip) {
		boolean matchFound = validateContact.validateZip(zip);
		if (matchFound)
			this.zip = zip;
		return matchFound;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public boolean setPhoneNo(String phoneNo) {
		boolean matchFound = validateContact.validatePhoneNo(phoneNo);
		if (matchFound)
			this.phoneNo = phoneNo;
		return matchFound;
	}

	public String getEmail() {
		return email;
	}

	public boolean setEmail(String email) {
		boolean matchFound = validateContact.validateEmail(email);
		if (matchFound)
			this.email = email;
		return matchFound;
	}

	@Override
	public String toString() {
		return "First Name :" + firstName + "\nLast Name :" + lastName + "\nAddress :" + address + "\nCity :" + city
				+ "\nState :" + state + "\nZip :" + zip + "\nPhone No :" + phoneNo + "\nEmail :" + email;
	}

}
