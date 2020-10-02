package com.capgemini;

import java.util.*;

public class AddressBook {
	public static void main(String[] args) {
		AddBook addressbook = new AddBook();
		Scanner sc = new Scanner(System.in);
		boolean matchFound = false;
		System.out.println("Welcome to Addressbook");
		System.out.println("Enter 1 to add contact");
		System.out.println("Enter 2 to edit contact");
		System.out.println("Enter 3 to see addressbook details");
		System.out.println("Enter 4 to exit");
		int option = sc.nextInt();
		while (option != 5) {
			if (option == 1)
				addressbook.addNewContact();
			else if (option == 2) {
				addressbook.editContact();
			} else if (option == 3)
				addressbook.showDetails();
			else if(option == 4)
				addressbook.deleteContact();
			else if (option == 5)
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
