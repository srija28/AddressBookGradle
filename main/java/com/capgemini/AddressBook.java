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
			System.out.println("Enter 7 to sort persons by city");
			System.out.println("Enter 8 to sort persons by state");
			System.out.println("Enter 9 to sort persons by zip");
			System.out.println("Enter 10 to see all addressbooks");
			System.out.println("Enter 11 to exit");
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
			else if (option == 7) {
				System.out.println(addressbook.sortPersonsByCity());
			}
			else if(option == 8) {
				System.out.println(addressbook.sortPersonsByState());
			}
			else if(option == 9) {
				System.out.println(addressbook.sortPersonsByZip());
			}
			else if(option == 10) {
				addressBookList.showDetails();
			}
			else if (option == 11)
				break;
			else {
				System.out.println("Please Enter Correct Choice");
			}
		}
		sc.close();
		System.out.println("Thank You");
	}
}