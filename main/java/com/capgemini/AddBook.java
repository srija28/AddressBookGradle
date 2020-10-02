package com.capgemini;

import java.util.*;
import com.capgemini.Contacts;

public class AddBook {
	Scanner in = new Scanner(System.in);
	private ArrayList<Contacts> contactList = new ArrayList<>();
	Map<String, Contacts> contactMap = new HashMap<>();
	static Map<String, AddressBook> addressBookList = new TreeMap<>();
	
	public void addNewContact() {
		boolean matchFound = false;
		Contacts person = new Contacts();
		System.out.print("First Name: ");
		while(!matchFound) {
		matchFound = person.setFirstName(in.next());
		}
		matchFound = false;
		System.out.print("Last Name: ");
		while(!matchFound) {
		matchFound = person.setLastName(in.next());
		}
		matchFound = false;
		System.out.print("Address: ");
		while(!matchFound) {
		matchFound = person.setAddress(in.next());
		}
		matchFound = false;
		System.out.print("City: ");
		while(!matchFound) {
		matchFound = person.setCity(in.next());
		}
		matchFound = false;
		System.out.print("State: ");
		while(!matchFound) {
		matchFound = person.setState(in.next());
		}
		matchFound = false;
		System.out.print("Zip: ");
		while(!matchFound) {
		matchFound = person.setZip(in.next());
		}
		matchFound = false;
		System.out.print("Phone Number: ");
		while(!matchFound) {
		matchFound = person.setPhoneNo(in.next());
		}
		matchFound = false;
		System.out.print("Email: ");
		while(!matchFound) {
		matchFound = person.setEmail(in.next());
		}
		String name = person.getFirstName()+" "+person.getLastName();
		Boolean keyPresent = contactMap.containsKey(name);
		if (keyPresent) {
			System.out.println("This name is already present\n");
		}else {
			contactList.add(person);
		contactMap.put(name, person);
		}
	}
	
	public void editContact(String firstName, String lastName) {
		String name = firstName+" "+lastName;
		boolean matchFound = false;
		Boolean keyPresent = contactMap.containsKey(name);
		if (keyPresent) {
			System.out.println("What do you want to update?");
			String s = in.next().toLowerCase();
			switch (s) {
			case ("address"):
				System.out.println("Enter address");
			while(!matchFound) {
				matchFound = contactMap.get(name).setAddress(in.next());
			}
				break;
			case ("city"):
				System.out.println("Enter city");
			while(!matchFound) {
				matchFound = contactMap.get(name).setCity(in.next());
			}
				break;
			case ("state"):
				System.out.println("Enter state");
			while(!matchFound) {
				matchFound = contactMap.get(name).setState(in.next());
			}
				break;
			case ("zip"):
				System.out.println("Enter zip");
			while(!matchFound) {
				matchFound = contactMap.get(name).setZip(in.next());
			}
				break;
			case ("phoneno"):
				System.out.println("Enter phone no");
			while(!matchFound) {
				matchFound = contactMap.get(name).setPhoneNo(in.next());
			}
				break;
			case ("email"):
				System.out.println("Enter email");
			while(!matchFound) {
				matchFound = contactMap.get(name).setEmail(in.next());
			}
				break;
			}
		} else {
			System.out.println("This name is not present in the address book.");
		}
	
		
	}

	public void showDetails() {
		if (contactList.size() == 0)
			System.out.println("No contacts to show");
			for (int i = 0; i < contactList.size(); i++) {
				Contacts person = contactList.get(i);
				System.out.println("\nContact :" + (i + 1));
				System.out.println(person);
			}
		
	}
}
