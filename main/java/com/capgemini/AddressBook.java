package com.capgemini;

import java.util.*;

public class AddressBook {
	public static void main(String[] args) {
		
		AddressBookList addressBookList = new AddressBookList();
		AddBook addressbook = new AddBook();
		Scanner sc = new Scanner(System.in);
		boolean matchFound = false;
		
		System.out.println("Welcome to Addressbook");
		System.out.println("Enter 1 to open existing addressBook");
		System.out.println("Enter 2 to open new address book");
		
		System.out.println("Enter 3 to exit");
		int option = sc.nextInt();
		while (option != 3) {
			if (option == 1)
				addressBookList.openAddressBook();
			else if (option == 2) {
				addressBookList.newAddressBook();
			} else if (option == 3)
				break;
			else {
				System.out.println("Please Enter Correct Choice");
			}
			System.out.println("Enter Choice");
			option = sc.nextInt();
		}
		System.out.println("Thank You");
	}
}