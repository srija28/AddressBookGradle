package com.capgemini;
import java.util.*;

public class AddressBookList {
	Scanner in = new Scanner(System.in);
	 Map<String, AddBook> addressBookMap = new TreeMap<>();
	 ArrayList<AddBook> addressList = new ArrayList<>();
	 public AddressBookList() {
			addressBookMap = new TreeMap<>();
		}
	 public Map<String, AddBook> getAddressBookMap() {
			return addressBookMap;
 }
 public void openAddressBook() {
	  System.out.println("Enter name of addressbook");
	  String bookName = in.next();
	  boolean keyPresent = addressBookMap.containsKey(bookName);
	  if(keyPresent) {
		  AddBook addressbook = addressBookMap.get(bookName);
	  System.out.println("Enter 1 to add contact");
     System.out.println("Enter 2 to edit contact");
     System.out.println("Enter 3 to see addressbook details");
     System.out.println("Enter 4 to delete contact");
     System.out.println("Enter 5 to exit");
    int option = in.nextInt();
     while(option!= 5) {
     if(option == 1)
     	addressbook.addNewContact();
     else if(option == 2) 
     	addressbook.editContact();
     else if (option == 3)
     	addressbook.showDetail();
     else if(option == 4) 
     	addressbook.deleteContact();
     else if(option == 5)
     	break;
     else
     System.out.println("Please Enter Correct Choice");  
     System.out.println("Enter Choice");
     option = in.nextInt();
     }
 }
	  else {
		 System.out.println("Address Book is not present"); 
	  }
 }
public void newAddressBook() {
	AddBook addressBook = new AddBook();
	System.out.println("Enter name of address book");
	String bookName = in.next();
	boolean keyPresent = addressBookMap.containsKey(bookName);
	if(keyPresent)
		System.out.println("Already Present");
	else
		addressBookMap.put(bookName, addressBook);
	
}
public void showDetails() {
	
	if(addressBookMap.size() == 0)
		System.out.println("No Address Book is present");
	else {
		for (int i = 0; i < addressList.size(); i++) {
			AddBook addBook = addressList.get(i);
			addBook.showDetail();
	}
}


}
}


