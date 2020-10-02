package com.capgemini;

import java.util.*;

public class AddressBook {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean matchFound = false;
		System.out.println("Welcome to Addressbook");

		Contacts person = new Contacts();
		System.out.print("First Name: ");
		while (!matchFound) {
			matchFound = person.setFirstName(sc.next());
		}
		matchFound = false;
		System.out.print("Last Name: ");
		while (!matchFound) {
			matchFound = person.setLastName(sc.next());
		}
		matchFound = false;
		System.out.print("Address: ");
		while (!matchFound) {
			matchFound = person.setAddress(sc.next());
		}
		matchFound = false;
		System.out.print("City: ");
		while (!matchFound) {
			matchFound = person.setCity(sc.next());
		}
		matchFound = false;
		System.out.print("State: ");
		while (!matchFound) {
			matchFound = person.setState(sc.next());
		}
		matchFound = false;
		System.out.print("Zip: ");
		while (!matchFound) {
			matchFound = person.setZip(sc.next());
		}
		matchFound = false;
		System.out.print("Phone Number: ");
		while (!matchFound) {
			matchFound = person.setPhoneNo(sc.next());
		}
		matchFound = false;
		System.out.print("Email: ");
		while (!matchFound) {
			matchFound = person.setEmail(sc.next());
		}
		System.out.println("Thank You");
	}
}
