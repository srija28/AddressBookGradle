package com.capgemini;

import java.util.*;

public class AddressBook {
	public static void main(String[] args) {
		
		AddressBookList addressBookList = new AddressBookList();
		AddBook addressbook = new AddBook();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Welcome to Addressbook");
		int option = 0;
		while (option != 7) {
			System.out.println("Enter 1 to open existing addressBook");
			System.out.println("Enter 2 to open new address book");
			System.out.println("Enter 3 to search persons in a city");
			System.out.println("Enter 4 to search persons in a state");
			System.out.println("Enter 5 to count persons in a state");
			System.out.println("Enter 6 to count persons in a city");
			System.out.println("Enter 7 to exit");
			option =sc.nextInt();
			if (option == 1)
				addressBookList.openAddressBook();
			else if (option == 2) {
				addressBookList.newAddressBook();
			} else if (option == 3) {
				System.out.println("Enter City");
				String city = sc.next();
				System.out.println(addressbook.searchPersonsByCity(city));}
			else if (option==4){
				System.out.println("Enter State");
				String state = sc.next();
				System.out.println(addressbook.searchPersonsByState(state));
			}
			else if(option==5) {
				System.out.println("Enter State");
				String state = sc.next();
				System.out.println(addressbook.countPersonsByState(state));
			}
			else if(option == 6) {
				System.out.println("Enter City");
				String city = sc.next();
				System.out.println(addressbook.countPersonsByCity(city));
			}
			else if (option == 7)
				break;
			else {
				System.out.println("Please Enter Correct Choice");
			}
		}
		sc.close();
		System.out.println("Thank You");
	}
}