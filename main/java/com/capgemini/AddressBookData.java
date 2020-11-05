package com.capgemini;

public class AddressBookData {
	public int id;
	public String firstname;
	public String last_name;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String phone;
	public String email;
	
	public AddressBookData(int id,String firstname, String last_name, String address, String city, String state, String zip, String phone, String email) {
		this.id=id;
		this.firstname = firstname;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}
	
	public AddressBookData(String firstname, String last_name, String address, String city, String state, String zip, String phone, String email) {
		//this.id=id;
		this.firstname = firstname;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "id=" + id + ", name=" + firstname+" "+last_name+" ";
	}
}