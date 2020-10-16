package com.capgemini;

import java.util.*;
import java.util.stream.Collectors;
import com.capgemini.Contacts;

public class AddBook {
	Scanner in = new Scanner(System.in);
	static LinkedList<Contacts> contactList = new LinkedList<>();
	Map<String, Contacts> contactMap = new HashMap<>();
	
	public AddBook() {
		contactMap = new HashMap<>();
	}
	public Map<String, Contacts> getContactMap() {
		return contactMap;
	}
	
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
		contactMap.put(name, person);
		}
	}
	
	public void editContact() {
		System.out.println("Enter First Name :");
    	String firstName = in.next();
    	System.out.println("Enter Last Name :");
    	String lastName = in.next();
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

	public void showDetail() {
		if(contactMap.size() == 0)
			System.out.println("No contacts to show");
		else {
			Set set = contactMap.entrySet();
			Iterator iterator = set.iterator();
			while(iterator.hasNext()) {
				Map.Entry entry = (Map.Entry)iterator.next();
				System.out.println(entry.getValue());
			}
		}
	}
	public void deleteContact() {
		System.out.println("Enter First Name :");
    	String firstName = in.next();
    	System.out.println("Enter Last Name :");
    	String lastName = in.next();
		String name = firstName+" "+lastName;
		Boolean keyPresent = contactMap.containsKey(name);
		if (keyPresent) {
			contactMap.remove(name);
		} else {
			System.out.println("This name is not present in address book.");
		}
	}
	
	public List<Contacts> searchPersonsByCity(String city) {
		return contactList.stream().filter(person -> person.getCity().equals(city)).collect(Collectors.toList());
	}

	public List<Contacts> searchPersonsByState(String state) {
		return contactList.stream().filter(person -> person.getState().equals(state)).collect(Collectors.toList());
	}
	public int countPersonsByCity(String city) {
		return contactList.stream().filter(person -> person.getCity().equals(city)).collect(Collectors.toList()).size();
	}

	public int countPersonsByState(String state) {
		return contactList.stream().filter(person -> person.getState().equals(state)).collect(Collectors.toList()).size();
	}
}
