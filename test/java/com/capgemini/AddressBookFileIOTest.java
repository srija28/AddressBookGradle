package com.capgemini;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class AddressBookFileIOTest {

	@Test
	public void givenContactsInFileShouldRead() {
		FileIOService addressBookFileIOService = new FileIOService();
		List<Contacts> contactList = new ArrayList<>();
		contactList = addressBookFileIOService.readData();
		System.out.println(contactList);
		Assert.assertEquals(2, contactList.size());
	}
	
	@Test
	public void writeContactsToFile() {
		FileIOService addressBookFileIOService = new FileIOService();
		List<Contacts> contactList = new ArrayList<>();
		Contacts contact1 = new Contacts("Shreya", "Reddy", "Miyapur", "Hyd", "Telangana", "500049", "9100887766", "shreya@gmail.com");
		Contacts contact2 = new Contacts("Vidushi", "Reddy", "ameerpet", "Nellore", "Andhra", "500099", "9278326743", "vidushi@gmail.com");
		contactList.add(contact1);
		contactList.add(contact2);
		System.out.println(contactList);
		addressBookFileIOService.writeData(contactList);
		Assert.assertEquals(2, addressBookFileIOService.countEntries());
	}

}
