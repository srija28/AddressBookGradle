package com.capgemini;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidateContact {
	public boolean validateFirstName(String firstName) {
		Pattern pattern = Pattern.compile("^([A-Z])[a-zA-Z]{2,}$");
		Matcher matcher = pattern.matcher(firstName);
		boolean matchFound = matcher.find();
		return matchFound;
	}

	public boolean validateLastName(String lastName) {
		Pattern pattern = Pattern.compile("^([A-Z])[a-zA-Z]{2,}$");
		Matcher matcher = pattern.matcher(lastName);
		Boolean matchFound = matcher.find();
		return matchFound;
	}


	
	public boolean validateAddress(String address) {
			return true;
	}

	public boolean validateCity(String city) {
		return true;
	}

	

	public boolean validateZip(String zip) {
		Pattern pattern = Pattern.compile("^([0-9]*){6}$");
		Matcher matcher = pattern.matcher(zip);
		Boolean matchFound = matcher.find();
		return matchFound;
	}

	public boolean validatePhoneNo(String phoneNo) {
		Pattern pattern = Pattern.compile("^\\d{2} [1-9]\\d{9}$");
		Matcher matcher = pattern.matcher(phoneNo);
		Boolean matchFound = matcher.find();
		return matchFound;
	}

	public boolean validateEmail(String email) {
		Pattern pattern = Pattern
				.compile("^([a-z]){1,}[a-z0-9]*([.+_-]){0,1}[0-9a-z]+(@){1}([0-9a-z]+)(\\.([a-z]){2,}){1}(\\.[a-z]{2,})?$");
		Matcher matcher = pattern.matcher(email);
		Boolean matchFound = matcher.find();
		return matchFound;
	}

	public boolean validateState(String state) {
		
		return true;
	}

}
